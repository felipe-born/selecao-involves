package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.LeitorDeArquivoBuilder;
import br.com.involves.selecao.modelo.ParametrosAplicacao;

public class LeitorDeArquivoFactory {
    public LeitorDeArquivoBuilder getLeitorDeArquivo(ParametrosAplicacao parametrosAplicacao) {
        return new LeitorDeArquivoBuilder(parametrosAplicacao);
    }
}
