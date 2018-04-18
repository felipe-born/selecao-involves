package br.com.involves.selecao.excecao;

public class LeituraDeArquivoException extends Throwable {
    public LeituraDeArquivoException(Exception exception) {
        super(exception);
    }
}
