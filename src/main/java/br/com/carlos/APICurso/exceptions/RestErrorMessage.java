package br.com.carlos.APICurso.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestErrorMessage {
    private HttpStatus status;
    private String message;


}
