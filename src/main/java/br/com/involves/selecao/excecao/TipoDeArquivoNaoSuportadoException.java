package br.com.involves.selecao.excecao;

import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.utilitarios.UtilitarioArquivo;

public class TipoDeArquivoNaoSuportadoException extends RuntimeException {

    public TipoDeArquivoNaoSuportadoException(ArquivoDeLeitura arquivo) {
        super("Esse tipo de arquivo não é suportado pela aplicação: " + arquivo.getExtensao() + ". Arquivo: " + arquivo.getCaminhoArquivo());
    }

    public TipoDeArquivoNaoSuportadoException(String arquivo) {
        super("Esse tipo de arquivo não é suportado pela aplicação: " + UtilitarioArquivo.getExtensao(arquivo) + ". Arquivo: " + arquivo);
    }
}
