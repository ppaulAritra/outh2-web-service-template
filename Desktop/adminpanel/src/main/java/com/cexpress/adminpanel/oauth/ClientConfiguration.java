package com.cexpress.adminpanel.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.ClientTokenServices;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

import com.cexpress.adminpanel.component.ApiUrlList;
import com.cexpress.adminpanel.component.Endpoint;
import com.cexpress.adminpanel.component.RestTemplateResponseErrorHandler;



@Configuration
@EnableOAuth2Client
public class ClientConfiguration {

	
	@Value("${cexpressapi.resource}")
    private String baseUrl;
	
	
    @Autowired
    private ClientTokenServices clientTokenServices;

    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Bean
    public OAuth2ProtectedResourceDetails passwordResourceDetails() {
        //@formatter:off
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();

       
        resourceDetails.setClientId("capital-express-client");
        resourceDetails.setClientSecret("capital-express-secret");
        resourceDetails.setGrantType("password");
       // resourceDetails.setGrantType("refresh_token");
        resourceDetails.setAccessTokenUri(baseUrl+ApiUrlList.oauthtoken);
       // resourceDetails.setScope(Arrays.asList("read_profile"));

        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
        //@formatter:on

        return resourceDetails;
    }

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {

        OAuth2ProtectedResourceDetails resourceDetails = passwordResourceDetails();

        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails,
                oauth2ClientContext);

        AccessTokenProviderChain provider = new AccessTokenProviderChain(
                Arrays.asList(new ResourceOwnerPasswordAccessTokenProvider()));

        provider.setClientTokenServices(clientTokenServices);
        template.setAccessTokenProvider(provider);
       template.setErrorHandler(new RestTemplateResponseErrorHandler());

        return template;
    }

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
    	
		return builder.errorHandler(new RestTemplateResponseErrorHandler())
		          .build();
    	//return builder.build();
	}
    
    
}
