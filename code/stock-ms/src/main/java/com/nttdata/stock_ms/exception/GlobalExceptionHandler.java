package com.nttdata.stock_ms.exception;

import com.nttdata.stock_ms.model.dto.ErrorDetailDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetailDto> handleNotFound(NotFoundException ex) {
        ErrorDetailDto error = new ErrorDetailDto();
        error.setMessage(ex.getMessage());
        error.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetailDto> handleBadRequest(BadRequestException ex) {
        ErrorDetailDto error = new ErrorDetailDto();
        error.setMessage(ex.getMessage());
        error.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorDetailDto> handleInternalServerError(InternalServerErrorException ex) {
        ErrorDetailDto error = new ErrorDetailDto();
        error.setMessage(ex.getMessage());
        error.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ErrorDetailDto error = new ErrorDetailDto();
        error.setMessage("Validación fallida: " + ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        error.setDateTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
