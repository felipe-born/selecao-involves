package br.com.involves.selecao.excecao;

public class TipoDeArquivoNaoSuportadoException extends RuntimeException {

    public TipoDeArquivoNaoSuportadoException() {
        super("Esse tipo de arquivo não é suportado pela aplicação!");
    }
}
