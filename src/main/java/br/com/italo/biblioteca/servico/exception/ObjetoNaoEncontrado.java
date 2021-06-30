package br.com.italo.biblioteca.servico.exception;

public class ObjetoNaoEncontrado extends RuntimeException{

    public ObjetoNaoEncontrado() {
        super();
    }

    public ObjetoNaoEncontrado(String message) {
        super(message);
    }

    public ObjetoNaoEncontrado(String message, Throwable cause) {
        super(message, cause);
    }
}
