package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.ControladorDaAplicacaoBuilder;

public class ControladorDaAplicacaoFactory {
    public ControladorDaAplicacaoBuilder getControladorDaAplicacao() {
        return new ControladorDaAplicacaoBuilder();
    }
}
