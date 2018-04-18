package br.com.involves.selecao.builder;

import br.com.involves.selecao.dominio.TipoDeArquivo;
import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.excecao.TipoDeArquivoNaoSuportadoException;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import javafx.util.Builder;

import java.io.FileNotFoundException;

public class LeitorDeArquivoBuilder implements Builder<LeitorDeArquivo> {

    private ArquivoDeLeitura arquivo;
    private final ParametrosAplicacao parametrosAplicacao;

    public LeitorDeArquivoBuilder(ParametrosAplicacao parametrosAplicacao) {

        this.parametrosAplicacao = parametrosAplicacao;
    }

    public LeitorDeArquivoBuilder doArquivo(String arquivo) throws FileNotFoundException {
        this.arquivo = new ArquivoDeLeituraBuilder(parametrosAplicacao)
                .comArquivo(arquivo)
                .build();
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