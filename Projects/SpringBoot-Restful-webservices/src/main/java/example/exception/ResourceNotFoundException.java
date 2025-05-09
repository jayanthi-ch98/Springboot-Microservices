package example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public String resource;
    public String fieldName;
    public Long FieldId;
    public ResourceNotFoundException(String resource,String fieldName,Long fieldId){
        super(String.format("%s not found with %s : %s",resource,fieldName,fieldId));
    }
}
