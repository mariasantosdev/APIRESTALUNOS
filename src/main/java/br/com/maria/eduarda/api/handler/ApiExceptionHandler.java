package br.com.maria.eduarda.api.handler;


import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontradoException(
            RecursoNaoEncontradoException ex, WebRequest request) {
        return this.handle(HttpStatus.NOT_FOUND, ex, request);
    
    }
    
    private ResponseEntity<Object> handle(
            HttpStatus status,
            Exception ex,
            WebRequest request) {
        String titulo = status.getReasonPhrase();
        String detalhes = ex.getMessage();

        RespostaProblema problema = new RespostaProblema();
        problema.setDetalhes(detalhes);
        problema.setStatus(status.value());
        problema.setTitulo(titulo);
     

        return this.handleExceptionInternal(ex, problema, null, status, request);
    
	
	}
}
