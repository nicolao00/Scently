package com.itsuda.perfume.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 사용자 정의 Exception 처리
    @ExceptionHandler(value = RestApiException.class)
    public ResponseEntity<? extends Object> handleRestApiException(RestApiException e) {
        log.error("HandleApiException throw RestApiException : {}", e.getMessage());
        return ResponseDto.toResponseEntity(e);
    }

    // 그 외 Exception 처리
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<? extends Object> handleException(Exception e) {
        log.error("HandleException throw Exception : {}", e.getMessage());
        return ResponseDto.toResponseEntity(e);
    }
}
