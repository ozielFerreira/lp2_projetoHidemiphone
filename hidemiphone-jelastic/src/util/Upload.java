package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




public class Upload {
	
	
	
	public static String upload(HttpServletRequest request, HttpServletResponse response, Part part, String path)
			throws ServletException, IOException {
		
		
		//final Part part = request.getPart("frente");
		final String filename = UUID.randomUUID().toString().replace("-", "")+".jpg";
		
		InputStream fileContent = null;
		OutputStream out = null;
		
		try {
			out = new FileOutputStream(new File(path)+File.separator+filename);
			fileContent = part.getInputStream();
			final byte[] bytes = new byte[1024];
			
			int read = 0;
			
			while ((read = fileContent.read(bytes))!=-1) {
				out.write(bytes, 0, read);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(out !=null) {
				out.close();
			}
			if(fileContent!=null) {
				fileContent.close();
			}
			
		}
		return filename;
		
	}
	
	public static String uploadIfExists(HttpServletRequest request, HttpServletResponse response, Part part, String path,String filename, OutputStream out)
			throws ServletException, IOException {
		
		
		//final Part part = request.getPart("frente");
		//final String filename = UUID.randomUUID().toString().replace("-", "")+".jpg";
		
		InputStream fileContent = null;
		//OutputStream out = null;
		
		try {
			out = new FileOutputStream(new File(path)+File.separator+filename);
			fileContent = part.getInputStream();
			final byte[] bytes = new byte[1024];
			
			int read = 0;
			
			while ((read = fileContent.read(bytes))!=-1) {
				out.write(bytes, 0, read);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(out !=null) {
				out.close();
			}
			if(fileContent!=null) {
				fileContent.close();
			}
			
		}
		return filename;
		
	}
}
