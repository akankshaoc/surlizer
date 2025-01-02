package dev.akanksha.surlizer;

import dev.akanksha.surlizer.exceptions.NoSuchUrlInUse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(NoSuchUrlInUse.class)
    public ResponseEntity<String> noSuchUrlExceptionHandler(NoSuchUrlInUse noSuchUrlInUse) {
        return new ResponseEntity<>(noSuchUrlInUse.getMessage(), HttpStatus.NOT_FOUND);
    }
}
