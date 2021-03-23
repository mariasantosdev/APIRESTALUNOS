package br.com.maria.eduarda.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ApiExceptionHandler{
    
	@ExceptionHandler(RecursoNaoEncontradoException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Recurso não encontrado")
    public void handleRecursoNaoEncontradoException() {
    
    }
    
}

