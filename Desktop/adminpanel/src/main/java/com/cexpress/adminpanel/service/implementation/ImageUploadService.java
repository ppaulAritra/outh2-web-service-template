package com.cexpress.adminpanel.service.implementation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cexpress.adminpanel.component.ApiUrlList;
import com.cexpress.adminpanel.component.Endpoint;
import com.cexpress.adminpanel.domain.Image;





@Service
public class ImageUploadService {

	
	String IMAGE_TMP_DIR = "\\D:\\temp" ;
	
	@Value("${cexpressapi.resource}")
    private String baseUrl;
	
	
	
	
	
	public Image uploadImage(MultipartFile  fileUploadBean) throws Exception {
		File file = null;
	
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
	
		
		Path tempFile = Files.createTempFile("pic2", ".jpg");
        Files.write(tempFile, fileUploadBean.getBytes());
        System.out.println("uploading: " + tempFile);
         file = tempFile.toFile();
		
		
		
         bodyMap.add("file", new FileSystemResource(file));

	    HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
        String tokenurl= baseUrl+Endpoint.fetchEndpoint(ApiUrlList.KEY_UPLOAD);
        RestTemplate restTemplate = new RestTemplate();
        Image  response =  restTemplate.postForObject(tokenurl, requestEntity, Image.class);
        
        if (file != null && file.exists()) {
            file.delete();
          }
        
        
        return response;
        
            
      
     
	}
	public Image uploadFile(MultipartFile  fileUploadBean) throws Exception {
		File file = null;
	
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
	
		
		Path tempFile = Files.createTempFile("temp", ".pdf");
        Files.write(tempFile, fileUploadBean.getBytes());
        System.out.println("uploading: " + tempFile);
         file = tempFile.toFile();
		
		
		
         bodyMap.add("file", new FileSystemResource(file));

	    HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
        String tokenurl= baseUrl+Endpoint.fetchEndpoint(ApiUrlList.KEY_UPLOAD);
        RestTemplate restTemplate = new RestTemplate();
        Image  response =  restTemplate.postForObject(tokenurl, requestEntity, Image.class);
        
   
        
        if (file != null && file.exists()) {
            file.delete();
          }
        
        
        return response;
        
   
     
	}
	
	

		 
}

