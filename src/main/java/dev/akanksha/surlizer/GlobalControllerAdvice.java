package dev.akanksha.surlizer;

import dev.akanksha.surlizer.exceptions.NoSuchUrlInUse;
import jakarta.persistence.NonUniqueResultException;
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

    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<String> nonUniqueResultExceptionHandler(NonUniqueResultException nonUniqueResultException) {
        return new ResponseEntity<>(nonUniqueResultException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
