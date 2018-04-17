package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.LeitorDeArquivoBuilder;

public class LeitorDeArquivoFactory {
    public LeitorDeArquivoBuilder getLeitorDeArquivo() {
        return new LeitorDeArquivoBuilder();
    }
}
