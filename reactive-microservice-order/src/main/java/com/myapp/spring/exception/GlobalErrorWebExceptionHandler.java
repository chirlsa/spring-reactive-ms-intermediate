
package com.myapp.spring.exception;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

   
   
//  public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes, Resources resources,
//          ApplicationContext applicationContext,ServerCodecConfigurer serverCodecConfigurer) {
//      super(errorAttributes, resources, applicationContext);
//      super.setMessageWriters(serverCodecConfigurer.getWriters());
//      super.setMessageReaders(serverCodecConfigurer.getReaders());
//  }
   
    public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes, WebProperties webProperties, ApplicationContext applicationContext,
            ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, webProperties.getResources(), applicationContext);
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        // TODO Auto-generated method stub
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }
   
    private Mono<ServerResponse> renderErrorResponse(final ServerRequest request){
        final Map<String, Object> errorPropertiesMap =  getErrorAttributes(request,ErrorAttributeOptions.defaults());
   
        HttpStatus ht =(HttpStatus) errorPropertiesMap.get("errorCode");
        errorPropertiesMap.remove("errorCode");
        errorPropertiesMap.put("errorCode", ht.value());
        return ServerResponse.status(ht)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorPropertiesMap));
       
    }

}