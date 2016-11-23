package com.sap.acme.imdb2.web.upload.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sap.acme.imdb2.web.model.MovieModel;

@Service
public class UploadService {
	
	private static final String SAVE_PATH = "C:/Users/i858148/workspace/IMDB2/Images/";
	
	public String saveFileAndReturnPath(MovieModel movie) throws Exception{
		MultipartFile multipartFile = movie.getThumbnail();
		if(haveFile(movie.getThumbnailPath(), multipartFile)){
			return "";
		}
		else{
			isValidFile(multipartFile);
			String fileName =  movie.getTitle() + multipartFile.getOriginalFilename();
			String path = SAVE_PATH + fileName;
			File fileLocation = new File(path);
			try {
				multipartFile.transferTo(fileLocation);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			return fileName;
		}
	}
	
	//Does not cover files extensions as TIF, PSD, SVG, however, prevents getting fooled by changed extensions
	private void isValidFile(MultipartFile uploadedFile) throws Exception{
		try (InputStream input = uploadedFile.getInputStream()) {
		    try {
		        ImageIO.read(input).toString();
		        // It's an image (only BMP, GIF, JPG and PNG are recognized).
		    } catch (Exception ex) {
		        throw new Exception("File uploaded is not an image or isn't supported format (BMP/GIF/JPG/PNG).");
		    }
		} catch (IOException ex) {
			throw new Exception("There was a problem with your upload, please try again later.");
		}
	}
	
	private boolean haveFile(String uploadedFileName, MultipartFile multipartFile) throws Exception{
		if(uploadedFileName == null || uploadedFileName.isEmpty() && multipartFile.getSize() <= 0){
			throw new Exception("The thumbnail field is mandatory.");
		}
		if(multipartFile.getSize() > 0){
			return false;
		}
		return true;
	}
}
