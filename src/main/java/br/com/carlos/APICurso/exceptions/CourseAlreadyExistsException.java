package br.com.carlos.APICurso.exceptions;

public class CourseAlreadyExistsException extends RuntimeException{
    public CourseAlreadyExistsException(){
        super("Course already exists");
    }
}
