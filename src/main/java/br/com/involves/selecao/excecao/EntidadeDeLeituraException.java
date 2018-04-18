package br.com.involves.selecao.excecao;

public class EntidadeDeLeituraException extends Throwable {
    public EntidadeDeLeituraException(Exception e) {
        super(e);
    }

    public EntidadeDeLeituraException(String mensagem) {
        super(mensagem);
    }
}
