package com.staxrt.tutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostProcessingException extends RuntimeException {

    public PostProcessingException(String message) {
        super(message);
    }

}
