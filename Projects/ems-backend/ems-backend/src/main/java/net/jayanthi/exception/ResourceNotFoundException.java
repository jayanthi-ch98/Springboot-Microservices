package net.jayanthi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String str;
    public ResourceNotFoundException(String str){
        super(str);
    }
}
