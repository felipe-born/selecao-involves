package br.com.involves.selecao.builder;

import br.com.involves.selecao.dominio.TipoDeParametro;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import javafx.util.Builder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ArquivoDeLeituraBuilder implements Builder<ArquivoDeLeitura> {
    private String arquivo;
    private ParametrosAplicacao parametrosAplicacao;
    private InputStream inputStream;


    public ArquivoDeLeituraBuilder(ParametrosAplicacao parametrosAplicacao) {
        this.parametrosAplicacao = parametrosAplicacao;
    }


    public ArquivoDeLeituraBuilder comArquivo(String arquivo) throws FileNotFoundException {
        this.arquivo = arquivo;
        this.inputStream = getInputStream(arquivo);
        return this;
    }

    private InputStream getInputStream(String arquivo) throws FileNotFoundException {
        return isArquivoDefault(arquivo) ?
                getResourceStreamDo(arquivo)
                : new FileInputStream(arquivo);
    }

    private InputStream getResourceStreamDo(String arquivo) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(arquivo);

        return resourceAsStream;
    }

    private boolean isArquivoDefault(String arquivo) {
        return TipoDeParametro.PARAMETRO_ARQUIVO.getValorPadrao().equals(arquivo);
    }

    @Override
    public ArquivoDeLeitura build() {
        return new ArquivoDeLeitura(arquivo, inputStream);
    }
}
