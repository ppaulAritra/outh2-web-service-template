package com.cexpress.adminpanel.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {

		return (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR
				|| httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {

		if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {

			StringBuilder inputStringBuilder = new StringBuilder();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getBody(), "UTF-8"));
			String line = bufferedReader.readLine();
			while (line != null) {
				inputStringBuilder.append(line);
				inputStringBuilder.append('\n');
				line = bufferedReader.readLine();
			}
			System.out.println("============================response begin==========================================");
			System.out.println("Status code  : {}" + httpResponse.getStatusCode());
			System.out.println("Status text  : {}" + httpResponse.getStatusText());
			System.out.println("Headers      : {}" + httpResponse.getHeaders());
			System.out.println("Response body: {}" + inputStringBuilder.toString());
			System.out.println("=======================response end=================================================");

			ApiError myObject = new ObjectMapper().readValue(inputStringBuilder.toString(), ApiError.class);
			// ApiError myObject = g.fromJson(inputStringBuilder, ApiError.class)
			System.out.println("this is error handler" + myObject);
			

		} else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
			System.out.println(httpResponse.getStatusText());
			if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
				try {
					throw new NotFoundException();
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(httpResponse.getStatusText());
				}
			}
		}

	}
	
	

}