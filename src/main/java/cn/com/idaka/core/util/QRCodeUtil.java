package cn.com.idaka.core.util;

import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import cn.com.idaka.core.exception.WeixinApiException;
import cn.com.idaka.core.message.helper.WeixinAPI;

public class QRCodeUtil {
	
	public static void main(String[] args) {
		
		try{
			System.setProperty("jsse.enableSNIExtension", "false");
			QRCodeUtil u = new QRCodeUtil();
			WeixinAPI api = new WeixinAPI("wx724d9143731e7c76", "4d8bf92d316584346743e43c1572507e");
			int[] qr = {1026,377,508,474,591,826,1057,732,1670,1773,644};
			for(int i=0; i<qr.length;i++){
				String ticket = api.getQRTicket(true, qr[i] );
				System.out.println( ticket );
				u.addQROnBackground(
					"D:\\package\\bg111.png", 
					//"http://img.baidu.com/img/image/200100.jpg",
					"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket,
					qr[i], 598, 175);
			}
		}catch(Exception e){
			
		} catch (WeixinApiException e) {
			e.printStackTrace();
		}
	}
	
	public void addQROnBackground(String backgroud,String qRfile,int sceneid, int x,int y){
		try{
			System.out.print("code:");System.out.println( sceneid );
			System.setProperty("jsse.enableSNIExtension", "false");
			
			    	// Create a trust manager that does not validate certificate chains
			        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			                return null;
			            }
			            public void checkClientTrusted(X509Certificate[] certs, String authType) {
			            }
			            public void checkServerTrusted(X509Certificate[] certs, String authType) {
			            }
			        } };
			        // Install the all-trusting trust manager
			        final SSLContext sc = SSLContext.getInstance("SSL");
			        sc.init(null, trustAllCerts, new java.security.SecureRandom());
			        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			        // Create all-trusting host name verifier
			        HostnameVerifier allHostsValid = new HostnameVerifier() {
			            public boolean verify(String hostname, SSLSession session) {
			                return true;
			            }
			        };

			        // Install the all-trusting host verifier
			       HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
//			           
//		   File formerFile = new File(backgroud); 
//           Image formerImage = ImageIO.read(formerFile); 
//           //以下2行代码分别获得图片的宽(width)和高(height) 
//           int width = formerImage.getWidth(null); 
//           int height = formerImage.getHeight(null); 
//           System.out.println("原始图片的宽为："+width+"\n原始图片的高为："+height); 
//           BufferedImage image = new BufferedImage(width, height, 
//                   BufferedImage.TYPE_INT_RGB); 
//           
//           FileOutputStream out = new FileOutputStream("D:/package/output/taxi"+ sceneid +".jpg"); 
//           //下面代码将被加上水印的图片转换为JPEG、JPG文件 
//           JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
//           JPEGEncodeParam jpegEncodeParam = encoder.getDefaultJPEGEncodeParam(image);  
//           jpegEncodeParam.setDensityUnit( JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);  
//           jpegEncodeParam.setXDensity(300);  
//           jpegEncodeParam.setYDensity(300); 
//           
//           Graphics g = image.createGraphics(); 
//           g.drawImage(formerImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING ), 0, 0, width, height, null); 
//
//	        URL url = new URL( qRfile );
//	        URLConnection con = url.openConnection();
//	       
//           Image waterMarkImage = ImageIO.read( con.getInputStream() ); 
//           
//           int widthWMI = (int)(waterMarkImage.getWidth(null)*0.65); 
//           int heightWMI = (int)(waterMarkImage.getHeight(null)*0.65); 
//           /** 
//            * 以下2行代码的x，y分别表示水印图片在原始图片的位置。 
//            * x,y为坐标。width，height为商品图片的宽和高。 
//            * width * 0.5 表示水印图片的水平位置覆盖在商品图片 
//            * 水平位置的正中间。height * 0.5 表示垂直位置。 
//            * 最终无论商品图片的宽高是多少，水印图片都会显示在 
//            * 商品图片的正中间。 
//            * 您可以根据您的需求，更改0.5这个数值，达到您想要的效果。 
//            * 这里我说的商品图片就是要被水印覆盖的图片。 
//            */ 
////           int x = (int)(width * 0.5); //"0.5"小数越大，水印越向左移动。 
////           int y = (int)(height * 0.5); //"0.5"小数越大，水印越向上移动。 
//           g.drawImage(waterMarkImage, x, y, widthWMI, heightWMI, null); 
//           g.setFont(new Font("Arial", Font.BOLD, 15));
//           g.setColor(Color.white );
//           g.drawString("NO:"+ sceneid , x, y+heightWMI+12);
//           
//           /** 
//            * 输出被加上水印的图片，也就是最终的效果。 
//            * 注意！下面代码的"D:\\1.jpg"是最后输出 
//            * 的文件，如果跟你原始文件的路径和名字相同 
//            * 的话，那么会覆盖掉原始文件。 
//            * 如：我的原始文件位于"D:\\1.jpg"，而下 
//            * 面的代码运行之后，我的原始文件就会丢失被 
//            * 覆盖掉。 
//            * 
//            * 您可以根据您的需要把加上水印后的图片放到 
//            * 您指定的文件路径。 
//            */ 
//           g.dispose(); 
// 
//           encoder.encode(image, jpegEncodeParam ); 
//           out.close(); 
//           System.out.println("水印已经添加成功！"); 
//           
           
       } catch (Exception e) { 
           e.printStackTrace(); 
       } 

	}

}
