package br.com.carlos.APICurso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.HttpClient;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CourseAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> courseAlreadyExistsHandler(CourseAlreadyExistsException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

    }

    @ExceptionHandler(CoursesNotFoundException.class)
    private ResponseEntity<RestErrorMessage> courseNotFoundHandler(CoursesNotFoundException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }  @ExceptionHandler(CourseDoesNotExistsException.class)
    private ResponseEntity<RestErrorMessage> courseDoesNotExistsHandler(CourseDoesNotExistsException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
