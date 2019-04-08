
package com.cexpress.adminpanel.component;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RefreshTokenErrorHandler extends ResponseEntityExceptionHandler {


@ExceptionHandler(value = {HttpClientErrorException.class})
public void handleConflict(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)throws IOException 
{
    
    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/logout");
}


}