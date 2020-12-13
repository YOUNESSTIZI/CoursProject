package com.example.demo.service.CreateService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

public class ImageLocation {
	
	/*
	 * this class has one method that save Image into a folder and crypt its name and return it !
	 */
	
	@Autowired
	private static Environment env ;

	public static String saveImage(MultipartFile imageFile) {
		MultipartFile file = imageFile;
		String imageId = UUID.randomUUID().toString();
		Path fileNameAndPath = Paths.get(env.getProperty("url.Files"),imageId+".jpeg");
		
		try {
			Files.write(fileNameAndPath,file.getBytes());
		}catch(IOException exp) {
			System.out.println(exp.getMessage());
		}
		
		return imageId+".jpeg";
	}

}
