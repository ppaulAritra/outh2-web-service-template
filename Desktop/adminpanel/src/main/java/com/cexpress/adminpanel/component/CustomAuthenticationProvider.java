package com.cexpress.adminpanel.component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;

import com.cexpress.adminpanel.domain.Authority;
import com.cexpress.adminpanel.domain.User;
import com.cexpress.adminpanel.oauth.SettingsRepository;





@Component
public class CustomAuthenticationProvider
  implements AuthenticationProvider {
 
	
	@Value("${cexpressapi.resource}")
    private String baseUrl;
	
	
	 @Autowired
     private OAuth2RestTemplate restTemplate;
	
     @Autowired
     private SettingsRepository settings;
     
     @Autowired
     private AccessTokenRequest accesstokenrequest;
	
     private Logger logger = LoggerFactory.getLogger(this.getClass());
 		List<User> users = new ArrayList<User>();
  

  
 	@Override
 	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
 		String name = authentication.getName();
 		String password = authentication.getCredentials().toString();
 	
 		  String endpoint = baseUrl+ApiUrlList.oauthtoken;
 		 

 		HttpHeaders headers = new HttpHeaders();
 		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
 		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
 		params.add("username", name);
 		params.add("password", password);
 		params.add("grant_type", "password");
 		params.add("client_id", "capital-express-client");
 		params.add("client_secret", "capital-express-secret" );
 		
 		
 		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

 		//HttpEntity<re>
 		try {
 		    ResponseEntity<User> response = restTemplate.exchange(endpoint,
 		        HttpMethod.POST, 
 		       request,
 		      User.class);
 		    settings.setAccessToken(response.getBody().getAccess_token());
 		    settings.setRefreshToken(response.getBody().getRefresh_token());
 		    Calendar calendar = Calendar.getInstance();
 		    calendar.setTimeInMillis(response.getBody().getExpires_in());
 		    settings.setExpiresIn(calendar);
 		    List<Authority> authorities =response.getBody().getAuthorities();
 		   
 		    settings.setRolename(authorities.get(0).getAuthority());
 		    
 		  
 		    settings.setUserId(response.getBody().getUserId());
 		    
 		    System.out.println("CustomAuthintication provider");
 		   	if(response.getBody().getIsDeleted().equals("true")) 
 		   	{
 		   		throw new BadCredentialsException("Your Account has been Deactivated. Please Contact Administrator");
 		   	}
 		
 		} catch (OAuth2AccessDeniedException e) {
 		   
 			throw new BadCredentialsException("Invalid Username or Password");
 		
 		}
 		catch ( ResourceAccessException e) {
  		   
 			throw new BadCredentialsException("Could not connect to remote server. Please wait a while and try again.");
 			
 		}

 		
 		
 		
 		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
 		
 		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, password,
 				grantedAuthorities);
  
 	
 		return auth;
 	}
  
 	@Override
 	public boolean supports(Class<?> authentication) {
 		return authentication.equals(UsernamePasswordAuthenticationToken.class);
 	}
    
    
    
    
    
    
    
    
    
    
}