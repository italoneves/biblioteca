package br.com.italo.biblioteca.servico.exception;

public class ObjetoExistente extends RuntimeException{
    public ObjetoExistente() {
        super();
    }

    public ObjetoExistente(String message) {
        super(message);
    }
}
