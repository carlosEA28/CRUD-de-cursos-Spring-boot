package br.com.carlos.APICurso.exceptions;

public class CoursesNotFoundException extends RuntimeException {
    public CoursesNotFoundException() {
        super("List of courses is empty");
    }
}
