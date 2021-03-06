package com.xoriant.ecart.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserInputException.class)
    public ResponseEntity<String> inputUserExceptionHandeler(UserInputException exception){
        return new ResponseEntity<String>("Please check User Inputs fileds !", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<String> inputUserExceptionHandeler(ElementNotFoundException exception){
        return new ResponseEntity<String>("Element Not Found in database!", HttpStatus.BAD_REQUEST);
    }
}
