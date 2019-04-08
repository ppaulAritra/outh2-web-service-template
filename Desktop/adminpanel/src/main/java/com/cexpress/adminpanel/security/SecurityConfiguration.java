package com.cexpress.adminpanel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   

   
   /* @Autowired
	private CustomAuthenticationProvider authProvider;*/
 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     
    	
    	
    	
    	
    	
    	http
        .csrf().disable()
        .authorizeRequests().antMatchers("/app-assets/**", "/register/**","/reset/request**").permitAll()
        .antMatchers("/invalidSession*").anonymous()
        .anyRequest().authenticated().and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home",true)
            .failureUrl("/login?error=true")
        .permitAll()
        
        .and()
       .sessionManagement()
            .invalidSessionUrl("/login").and()
        .logout()
           .invalidateHttpSession(true)
            .logoutSuccessUrl("/login") ///logout.html?logSucc=true
            .deleteCookies("JSESSIONID")
            .permitAll()
         
            
            ;
    	
    	
    	
    	
    	
    	
    	
    	
      //@formatter:on
    }
    
  
    
    @Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

// below code is only for in memory 
  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("a-user-c")
          .password(encoder.encode("00000000"))
          .roles("USER");
    }*/
    
}
