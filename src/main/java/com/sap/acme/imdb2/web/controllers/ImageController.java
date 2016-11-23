package com.sap.acme.imdb2.web.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	private static final String PATH = "C:/Users/i858148/workspace/IMDB2/Images/";
	
	@RequestMapping(value = "/getImage/{fileName:.+}")
	@ResponseBody
	public byte[] getImage(@PathVariable String fileName, HttpServletRequest request)  {
		Path path = Paths.get(PATH + fileName);
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			return null;
		} 
		return data;
	}
}
