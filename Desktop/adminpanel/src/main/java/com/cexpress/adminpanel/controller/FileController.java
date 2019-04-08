/**
 * 
 */
package com.cexpress.adminpanel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cexpress.adminpanel.domain.Image;
import com.cexpress.adminpanel.service.implementation.ImageUploadService;




/**
 * @author Aritra
 *
 */
@RestController
@RequestMapping("/upload")
public class FileController {
	@Autowired
	ImageUploadService imageUpload;
	public Image uploadFile(
		    @RequestParam("uploadfile") MultipartFile uploadfile) throws Exception  {
		Image mv;
		if(!uploadfile.getContentType().equals("application/pdf"))
			
			{
			System.out.println("File type"+uploadfile.getContentType());
			  mv = imageUpload.uploadImage(uploadfile);
			 
			}
		else
		{
			  mv = imageUpload.uploadFile(uploadfile);
			 
		}
		System.out.println(mv.toString());
		     return mv;
			 
		}
	
}
