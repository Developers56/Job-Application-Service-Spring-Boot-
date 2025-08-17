package com.learning.jobappservice.RegisterApi;

import com.learning.jobappservice.InvalidInputException;
import com.learning.jobappservice.RegisterApi.Model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        ApiResponse response = new ApiResponse(400, errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    // Handle custom exceptions like duplicate CNIC or mobile
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ApiResponse> handleInvalidInput(InvalidInputException ex) {
        ApiResponse response = new ApiResponse(400, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle other unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneralException(Exception ex) {
        ApiResponse response = new ApiResponse(500, "Internal server error");
        ex.printStackTrace(); // (Optional) log the actual stack trace for debugging
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
