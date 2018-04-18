package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.ControladorDeInterfaceDeUsuarioBuilder;

public class ControladorDeInterfaceDeUsuarioFactory {
    public ControladorDeInterfaceDeUsuarioBuilder getControladorDeInterface() {
        return new ControladorDeInterfaceDeUsuarioBuilder();
    }
}
