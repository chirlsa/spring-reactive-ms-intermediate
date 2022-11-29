package com.myapp.spring.exception;

import java.rmi.ServerException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

	
	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
		// TODO Auto-generated method stub
		Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable error = getError(request);
        if (error instanceof ServerException) {
            errorAttributes.put("errorCode", ((ServerException) error).getCause());
            errorAttributes.put("data", error.getMessage());
        } else {
            errorAttributes.put("errorCode", HttpStatus.SERVICE_UNAVAILABLE);
            errorAttributes.put("data"," ERROR On My Server");
        }
        return errorAttributes;
	}
}
