package com.sparken.ImagePractice.helper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUploadHelper {
	
	public final String UPLOAD_DIR = "/root/Pictures/ImagePractice/src/main/resources/static/image";
	
	public boolean uploadImage(MultipartFile multipartFile)
	{
		boolean f = false;
		
		try {
			//read
			
//			InputStream is = multipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			//write
//			FileOutputStream fos =new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			f= true;
			
			Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f= true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;		
	}

}
