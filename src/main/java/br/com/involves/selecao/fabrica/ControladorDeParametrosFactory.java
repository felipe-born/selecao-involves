package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.ControladorDeParametrosBuilder;

public class ControladorDeParametrosFactory {

    public ControladorDeParametrosBuilder getControladorDeParametros() {
        return new ControladorDeParametrosBuilder();
    }
}
