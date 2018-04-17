package br.com.involves.selecao.excecao;

public class ValidacaoException extends Exception {
    public ValidacaoException(Exception exception) {
        super(exception);
    }

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
