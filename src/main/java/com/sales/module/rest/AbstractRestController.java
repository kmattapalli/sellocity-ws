package com.sales.module.rest;



import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sales.module.domain.ResponseError;

@ControllerAdvice
public abstract class AbstractRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRestController.class);
    public static final String REFERENCE_NUMBER_KEY = "refNumber";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseError handleException(final Exception exception) {
    	StringWriter sw = new StringWriter();
    	PrintWriter pw = new PrintWriter(sw);
    	exception.printStackTrace(pw);
    	// stack trace as a string
        final String message = sw.toString(); 
        LOGGER.error(message);
        return new ResponseError(exception.getMessage());
    }
    
}
