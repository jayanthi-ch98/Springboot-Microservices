package example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice

//@ControllerAdvice ---> used to say its global exception handler---> all teh exceptions handled at single place
//ResponseEntityExceptionHandler---> used to handle Bean Validations for requests body-->can customise error messages when validations fails
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    //@ExceptionHandler--> to handle any particular custom exception
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webrequest){
        ErrorDetails  error = new ErrorDetails(
                LocalDateTime.now(),exception.getMessage(), "USER_NOT_FOUND", webrequest.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
@ExceptionHandler(EmailAlreadyExistsException.class)
//@ExceptionHandler--> to handle any particular custom exception
public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception, WebRequest webrequest){
    ErrorDetails  error = new ErrorDetails(
            LocalDateTime.now(),exception.getMessage(), "EMAIL_ALREADY_EXISTS", webrequest.getDescription(false));
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}


    //to handle any global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webrequest){
        ErrorDetails  error = new ErrorDetails(
                LocalDateTime.now(),exception.getMessage(), "INTERNAL_SERVER_ERROR", webrequest.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> errorDetails=new HashMap<>();
        System.out.println("Entered the handleMethod Argument Not valid");
        List<ObjectError> errorList= ex.getBindingResult().getAllErrors();
        errorList.forEach(error->
        {
            String FieldKey = ((FieldError)error).getField();
            String message=error.getDefaultMessage();
            errorDetails.put(FieldKey,message);
        });
    return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


