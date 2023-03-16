package com.springbootcrud.springbootcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotNullException.class)
    public ResponseEntity<?> studentNotNull(StudentNotNullException studentNotNullException) {
        List<String> errorList = new ArrayList<>();
        errorList.add(studentNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Information is NULL!", errorList);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotFound(StudentNotFoundException studentNotFoundException) {
        List<String> errorList = new ArrayList<>();
        errorList.add(studentNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Student not found!", errorList);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
