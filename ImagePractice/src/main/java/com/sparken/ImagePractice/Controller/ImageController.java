package com.sparken.ImagePractice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sparken.ImagePractice.helper.ImageUploadHelper;

@RestController
public class ImageController {
	
	@Autowired
	ImageUploadHelper imageUploadHelper;
	
	@PostMapping("/upload-image")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile)
	{
		try {
			
			if(multipartFile.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			
			if(!multipartFile.getContentType().equals("image/jpeg"))
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG is allowed");
			}
			
			boolean f = imageUploadHelper.uploadImage(multipartFile);
			
			if(f) {
				return ResponseEntity.ok("Image Uploaded SuccessFully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wromg");
		
	}

}
