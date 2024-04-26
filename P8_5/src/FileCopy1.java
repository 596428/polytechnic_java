import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.print.DocFlavor.URL;

public class FileCopy1 {
	public static void main(String[] args) {
		// 복사본은 프로젝트의 현재 위치에 생성됨
		
		InputStream in = null;
		OutputStream out = null;
		try {
//			String urlStr = "https://wallpapercave.com/wp/wp2411715.jpg";
//		    URL url = new URL(urlStr);
//		    InputStream in = ((Object) url).openStream();
//		    in = conn.getInputStream();
		    
		    String path = "C:\\Users\\SMART13\\Desktop\\WallPaper\\1318724.jpeg";
			in = new FileInputStream(path);
			out = new FileOutputStream("copy.jpeg");
			while(true) {
				int data = in.read();
				if(data == -1) {
					break;
				}
				out.write(data);
			}//end while
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(in !=null) {
				try {in.close();}catch(Exception e){}
			}
			if(out !=null) {
				try {out.close();}catch(Exception e){}
			}
		}
	
	
	}//end main

}
