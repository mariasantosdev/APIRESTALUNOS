package br.com.maria.eduarda.api.handler;

public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -2770807206423104742L;

	public RecursoNaoEncontradoException(String message) {
        super(message);
    }

    public RecursoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecursoNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}

