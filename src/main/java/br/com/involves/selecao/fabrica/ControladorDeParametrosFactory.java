package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.ControladorDeParametrosAplicacaoBuilder;

public class ControladorDeParametrosFactory {

    public ControladorDeParametrosAplicacaoBuilder getControladorDeParametros() {
        return new ControladorDeParametrosAplicacaoBuilder();
    }
}
