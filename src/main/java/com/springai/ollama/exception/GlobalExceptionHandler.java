/*
 * @author Muhammad Ubaid Ur Raheem Ahmad AKA Shahbaz Haroon
 * Email: shahbazhrn@gmail.com
 * Cell: +923002585925
 * GitHub: https://github.com/ShahbazHaroon
 */

package com.springai.ollama.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MissingInputException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundException(final MissingInputException resourceNotFoundException) {
        var error = new ErrorDetails(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
