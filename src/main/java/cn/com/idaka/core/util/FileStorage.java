package cn.com.idaka.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileStorage {
	
	public FileStorage() {
		super();
	}

	public FileStorage(String root) {
		DOCUMENT_ROOT = root;
	}

	private String DOCUMENT_ROOT = Config.uploadDir;
	
	static Logger logger = LoggerFactory.getLogger(FileStorage.class);

	public String fileUploadSave(MultipartFile file,String uri, String filename){
		if (file != null) {			
			String originname = file.getOriginalFilename();
			if(originname!=null && originname.length()>0){
				StringBuffer path = new StringBuffer("/");
				if(uri!=null && uri.length()>0) path.append(uri).append("/");
				
				//检查目录是否存在
				File dirs = new File(DOCUMENT_ROOT.concat( path.toString() ));
				if(!dirs.exists()){
					dirs.mkdirs();
				}
				
				//设置文件名和扩展名
				path.append( filename );
				
				if(logger.isDebugEnabled()){
					logger.debug("storage:"+file.getSize());
					logger.debug("storage to:".concat( path.toString() ));
				}
				try {
					file.transferTo( new File(DOCUMENT_ROOT.concat( path.toString() )));
					return new StringBuffer().append(path).toString();
				} catch (IOException e) {
					logger.error( "upload failed!" );
					logger.error( e.getMessage() );
				}
			}
		}
		return null;
	}
	
	public String save(MultipartFile file,String account, String toDir){
		return save(file, account, toDir, null, false);
	}
	
	public String save(MultipartFile file,String account, String toDir, String toName, boolean isThumb){
		
		if (file != null) {			
			String originname = file.getOriginalFilename();
			if(originname!=null && originname.length()>0){
				Calendar cal = Calendar.getInstance();
				StringBuffer path = new StringBuffer("/").append(account).append("/")
						.append(toDir).append("/").append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)).append("/");
				
				//检查目录是否存在
				File dirs = new File(DOCUMENT_ROOT.concat( path.toString() ));
				if(!dirs.exists()){
					dirs.mkdirs();
				}
				
				//设置文件名和扩展名
				StringBuffer sb = new StringBuffer().append(System.currentTimeMillis());
				if(toName != null)
					sb.append("-").append(toName);
				path.append(sb.toString()).append( getExt(file.getContentType(),originname) );
				
				if(logger.isDebugEnabled()){
					logger.debug("storage:"+file.getSize());
					logger.debug("storage to:".concat( path.toString() ));
				}
				try {
					file.transferTo( new File(DOCUMENT_ROOT.concat( path.toString() )));
					return new StringBuffer().append(path).toString();
				} catch (IOException e) {
					logger.error( "upload failed!" );
					logger.error( e.getMessage() );
				}
			}
		}
		return null;
	}
	
	public String save(byte[] file,String account, String toDir, String toName,String contentType){
		
		if (file != null) {	
		
			Calendar cal = Calendar.getInstance();
			StringBuffer path = new StringBuffer("/").append(account).append("/")
					.append(toDir).append("/").append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)).append("/");
			
			//检查目录是否存在
			File dirs = new File(Config.uploadDir.concat( path.toString() ));
			if(!dirs.exists()){
				dirs.mkdirs();
			}
			//设置文件名和扩展名
			path.append( toName==null?System.currentTimeMillis():toName ).append( getExt(contentType,"") );
			
			if(logger.isDebugEnabled()){
				logger.debug("storage:"+file.length);
				logger.debug("storage to:".concat( path.toString() ));
			}
			try {
				
				FileOutputStream fos = new FileOutputStream(Config.uploadDir.concat( path.toString() ));
				fos.write( file );
				fos.close();
				
				return new StringBuffer().append(path).toString();
			} catch (IOException e) {
				logger.error( "upload failed!" );
				logger.error( e.getMessage() );
			}
		}
		return null;
	}
	
	private String getExt(String contentType,String originname){
		
		if("image/jpeg".equals(contentType)){
			return ".jpg";
		}else if("image/png".equals(contentType)){
			return ".png";
		}else if("image/gif".equals(contentType)){
			return ".gif";
		}else if("image/tiff".equals(contentType)){
			return ".tif";
		}else if("audio/wav".equals(contentType)){
			return ".wav";
		}else if("audio/x-ms-wma".equals(contentType)){
			return ".wma";
		}else if("audio/mp3".equals(contentType)){
			return ".mp3";
		}else if("audio/amr".equals(contentType)){
			return ".amr";
		}else if("video/x-ms-asf".equals(contentType)){
			return ".asf";
		}else if("video/avi".equals(contentType)){
			return ".avi";
		}else if("video/mpeg4".equals(contentType)){
			return ".mp4";
		}else if("video/mpg".equals(contentType)){
			return ".mpeg";
		}else if("video/x-ms-wmv".equals(contentType)){
			return ".wmv";
		}else if("video/x-ms-asf".equals(contentType)){
			return ".asf";
		}else if("application/vnd.ms-excel".equals(contentType)){
			return ".xls";
		}else{
			int index=originname.lastIndexOf(".");
			return originname.substring(index);
		}
	}
}
