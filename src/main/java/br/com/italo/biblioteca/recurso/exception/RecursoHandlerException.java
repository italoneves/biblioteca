package br.com.italo.biblioteca.recurso.exception;

import br.com.italo.biblioteca.servico.exception.ObjetoExistente;
import br.com.italo.biblioteca.servico.exception.ObjetoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice //Interceptor de exception global dos controllers
public class RecursoHandlerException {

    @ExceptionHandler(ObjetoNaoEncontrado.class) //Manipulador da exception
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontrado objetoNaoEncontrado, ServletRequest request){
        LocalDateTime localDateTime = LocalDateTime.now();
        ErroPadrao erroPadrao =
                new ErroPadrao(localDateTime, objetoNaoEncontrado.getMessage(), HttpStatus.NOT_FOUND.value());
        //Data e hora, mensagem do exception, numeração do erro

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);

    }

    @ExceptionHandler(ObjetoExistente.class)
    public ResponseEntity<ErroPadrao> exceptionObjetoExistente(ObjetoExistente objetoExistente, ServletRequest servletRequest){
        LocalDateTime localDateTime = LocalDateTime.now();
        ErroPadrao erroPadrao = new ErroPadrao(localDateTime,objetoExistente.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadrao);


    }

}
