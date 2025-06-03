package ru.aloeok.wrtask.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.aloeok.wrtask.dto.ErrorDto;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDto> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest()
                .body(ErrorDto.builder()
                        .details(e.getMessage())
                        .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.badRequest()
                .body(ErrorDto.builder()
                        .details(e.getMessage())
                        .build());
    }
}
