package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.LeitorDeArquivoBuilder;
import br.com.involves.selecao.modelo.ParametrosAplicacao;

import java.io.FileNotFoundException;

public class LeitorDeArquivoFactory {
    public LeitorDeArquivoBuilder getLeitorDeArquivo(ParametrosAplicacao parametrosAplicacao) throws FileNotFoundException {
        return new LeitorDeArquivoBuilder(parametrosAplicacao);
    }
}
