package cn.com.idaka.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * Excel帮助类，提供Excel的相关处理
 * @author madongdong
 */
public class ExcelUtil {

	public static List<Map<String, String>> parseExcelFile(String path) {
		return null;
	}

	public static List<Map<String, String>> parseExcelResource(String path) {
		InputStream is = null;
		try {
			is = ExcelUtil.class.getResourceAsStream(path);
			int i = path.lastIndexOf(".");
			String ext = i >= 0 ? path.substring(i+1) : path;
			return parseExcelStream(is,ext);
		} finally {
			IoUtil.safeClose(is);
		}
	}
	
	public static List<Map<String, String>> parseMultipartFile(MultipartFile file) {
		InputStream is = null;
		try {
			is = file.getInputStream();
			
			String fileName = file.getOriginalFilename();
			int i = fileName.lastIndexOf(".");
			String ext = i >= 0 ? fileName.substring(i+1) : fileName;
			
			return parseExcelStream(is,ext);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			IoUtil.safeClose(is);
		}
	}
	
	
	
	public static List<Map<String, String>> parseExcelStream(InputStream is, String ext) {
		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();

		Workbook wb = null;
		try {
			if ("xlsx".equals(ext))
				wb = new XSSFWorkbook(is);
			else
				wb = new HSSFWorkbook(is);

			Sheet sheet = wb.getSheetAt(0);
			int n = sheet.getPhysicalNumberOfRows();

			Row header = sheet.getRow(0);
			List<String> fields = parseRow(header);
			if (fields == null || fields.isEmpty())
				return null;

			for (int i = 1; i < n; i++) {
				Row row = sheet.getRow(i);
				List<String> values = parseRow(row);
				if(values == null || values.isEmpty())
					continue;

				Map<String, String> map = new HashMap<String, String>();
				for (int j = 0; j < fields.size(); j++) {
					String field = fields.get(j);
					String value = values.size() >= j + 1 ? values.get(j) : null;
					map.put(field, value);
				}
				ret.add(map);
			}

			return ret;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	private static List<String> parseRow(Row row) {
		if(row == null)
			return null;
		
		List<String> ret = new ArrayList<String>();

		Iterator<Cell> it = row.cellIterator();
		while (it.hasNext()) {
			Cell cell = it.next();
			String value = null;
			
			switch (cell.getCellType()) { // 根据cell中的类型来输出数据
				case HSSFCell.CELL_TYPE_NUMERIC:
					value = Double.toString(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					value = Boolean.toString(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					value = cell.getCellFormula();
					break;
				default:
					break;
			}
			ret.add(value);
		}

		return ret;
	}
	
	
	/** 导出excel下载 */
	public static void renderToExcel(List<String> keys, List<Map<String,String>> data, HttpServletResponse response) throws IOException{
		if(keys == null || keys.isEmpty() || data == null || data.isEmpty())
			return;
		
		// 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet
        Sheet sheet = wb.createSheet("data");
        
        // 创建标题行
        Row row = sheet.createRow((short) 0);
        for(int i = 0; i < keys.size(); i++){
        	String fieldName = keys.get(i);
        	Cell cell = row.createCell(i);
        	cell.setCellValue(fieldName);
        }
        
        for(int j = 0; j < data.size(); j++){
        	Map<String,String> map = data.get(j);
        	Row r = sheet.createRow(j+1);
        	
        	for(int i = 0; i < keys.size(); i++){
            	String fieldName = keys.get(i);
            	Object value = map.get(fieldName);
            	Cell cell = r.createCell(i);
            	cell.setCellValue(value != null ? value.toString() : null);
            }
        }
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=data.xls");

        ServletOutputStream out = response.getOutputStream();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {

            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);

            byte[] buff = new byte[2048];
            int bytesRead;

            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        }
        finally {
            if (bis != null) bis.close();
            if (bos != null) bos.close();
        }
        return;
	}

}