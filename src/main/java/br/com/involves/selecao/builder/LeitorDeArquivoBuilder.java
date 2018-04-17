package br.com.involves.selecao.builder;

import br.com.involves.selecao.dominio.TipoDeArquivo;
import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.excecao.TipoDeArquivoNaoSuportadoException;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import javafx.util.Builder;

public class LeitorDeArquivoBuilder implements Builder<LeitorDeArquivo> {

    private ArquivoDeLeitura arquivo;

    public LeitorDeArquivoBuilder doArquivo(String arquivo) {
        this.arquivo = new ArquivoDeLeitura(arquivo);
        return this;
    }

    @Override
    public LeitorDeArquivo build() {
        TipoDeArquivo tipoDeArquivo = TipoDeArquivo.getTipoDeArquivo(arquivo.getExtensao());
        if (tipoDeArquivo == null)
            throw new TipoDeArquivoNaoSuportadoException(arquivo);
        return new LeitorDeArquivo(tipoDeArquivo.getLinhaHandler(), arquivo);
    }
}
