package br.com.involves.selecao.builder;

import br.com.involves.selecao.dominio.TipoDeArquivo;
import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.excecao.TipoDeArquivoNaoSuportadoException;
import javafx.util.Builder;

public class LeitorDeArquivoBuilder implements Builder<LeitorDeArquivo> {

    private String arquivo;

    public LeitorDeArquivoBuilder doArquivo(String arquivo) {
        this.arquivo = arquivo;
        return this;
    }

    @Override
    public LeitorDeArquivo build() {
        TipoDeArquivo tipoDeArquivo = TipoDeArquivo.getTipoDeArquivo(arquivo);
        if (tipoDeArquivo == null)
            throw new TipoDeArquivoNaoSuportadoException();
        return new LeitorDeArquivo(tipoDeArquivo.getLinhaHandler(), arquivo);
    }
}
