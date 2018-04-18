package br.com.involves.selecao.builder;

import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import javafx.util.Builder;

public class ArquivoDeLeituraBuilder implements Builder<ArquivoDeLeitura> {
    private String arquivo;
    private ParametrosAplicacao parametrosAplicacao;


    public ArquivoDeLeituraBuilder(ParametrosAplicacao parametrosAplicacao) {
        this.parametrosAplicacao = parametrosAplicacao;
    }


    public ArquivoDeLeituraBuilder comArquivo(String arquivo) {
        this.arquivo = isArquivoDefault(arquivo) ? getCaminhoArquivoDoResource(arquivo) : arquivo;
        return this;
    }

    private String getCaminhoArquivoDoResource(String arquivo) {
        ClassLoader classLoader = getClass().getClassLoader();
        String caminhoArquivo = classLoader.getResource(arquivo).getFile();

        return caminhoArquivo;
    }

    private boolean isArquivoDefault(String arquivo) {
        return parametrosAplicacao.getArquivo().equals(arquivo);
    }

    @Override
    public ArquivoDeLeitura build() {
        return new ArquivoDeLeitura(arquivo);
    }
}
