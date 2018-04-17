package br.com.involves.selecao.excecao;

import java.io.IOException;

public class LeituraDeArquivoException extends Throwable {
    public LeituraDeArquivoException(IOException exception) {
        super(exception);
    }
}
