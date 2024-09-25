package br.com.carlos.APICurso.exceptions;

public class CourseDoesNotExistsException extends RuntimeException {
    public CourseDoesNotExistsException() {
        super("Course not found or does not exists");
    }
}
