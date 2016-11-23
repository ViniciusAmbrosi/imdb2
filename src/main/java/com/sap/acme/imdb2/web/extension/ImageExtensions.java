package com.sap.acme.imdb2.web.extension;

import java.io.File;
import java.io.IOException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageExtensions {

	private static final String LOAD_PATH = "C:/Users/i858148/workspace/IMDB2/Images/";
	
	public static MultipartFile getMultipartFileFromFile(String fileName){
		File file = new File(LOAD_PATH + fileName);
		
	    DiskFileItem fileItem = 
	    		new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length() , file.getParentFile());
	    try {
			fileItem.getOutputStream();
			MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
			return multipartFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
