package br.com.involves.selecao.factory;

import br.com.involves.selecao.builder.ControladorDeParametrosAplicacaoBuilder;

public class ControladorDeParametrosFactory {

    public ControladorDeParametrosAplicacaoBuilder getControladorDeParametros() {
        return new ControladorDeParametrosAplicacaoBuilder();
    }
}
