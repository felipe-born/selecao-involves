package br.com.involves.selecao.factory;

import br.com.involves.selecao.builder.ControladorDaAplicacaoBuilder;

public class ControladorDaAplicacaoFactory {
    public ControladorDaAplicacaoBuilder getControladorDaAplicacao() {
        return new ControladorDaAplicacaoBuilder();
    }
}
