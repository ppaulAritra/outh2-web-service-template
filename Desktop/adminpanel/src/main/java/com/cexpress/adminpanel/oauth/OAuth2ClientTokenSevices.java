package com.cexpress.adminpanel.oauth;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.ClientTokenServices;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;


@Service
public class OAuth2ClientTokenSevices implements ClientTokenServices {
    //@formatter:off

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SettingsRepository settings;

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2ProtectedResourceDetails resource, Authentication authentication) {
        //ClientUser clientUser = getClientUser(authentication);

        String accessToken = settings.getAccessToken();
        Calendar expirationDate = settings.getExpiresIn();

        String refrehToken = settings.getRefreshToken();
        
        if (accessToken == null) return null;

        logger.info("Get Access Token  in "+accessToken);
        logger.info(" Get Refresh Token  in "+refrehToken);

        
        
        
        DefaultOAuth2AccessToken oAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
        oAuth2AccessToken.setExpiration(expirationDate.getTime());
        //oAuth2AccessToken.setRefreshToken();
        oAuth2AccessToken.setRefreshToken(new DefaultOAuth2RefreshToken(settings.getRefreshToken()));

        logger.info("Get Again Access Token  in "+oAuth2AccessToken.getValue());
        logger.info(" Get Again Refresh Token  in "+oAuth2AccessToken.getRefreshToken().getValue());
        
        return oAuth2AccessToken;
    }

    @Override
    public void saveAccessToken(OAuth2ProtectedResourceDetails resource,
            Authentication authentication, OAuth2AccessToken accessToken) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.setTime(accessToken.getExpiration());

        //ClientUser clientUser = getClientUser(authentication);

        /*clientUser.setAccessToken(accessToken.getValue());
        clientUser.setAccessTokenValidity(expirationDate);*/
        settings.setAccessToken(accessToken.getValue());
        settings.setExpiresIn(expirationDate);
        settings.setRefreshToken(accessToken.getRefreshToken().getValue());
        
        
        logger.info("Save Access Token  in "+settings.getAccessToken());
        logger.info("Save Refresh Token  in "+settings.getRefreshToken());
        
        //users.save(clientUser);
    }

    @Override
    public void removeAccessToken(OAuth2ProtectedResourceDetails resource,
            Authentication authentication) {
    

        settings.setAccessToken(null);
        settings.setExpiresIn(null);
        //settings.setRefreshToken(null);
        logger.info("Remove Access Token  in "+settings.getAccessToken());
        logger.info("Remove Refresh Token  in "+settings.getRefreshToken());
   
    }

   
}
