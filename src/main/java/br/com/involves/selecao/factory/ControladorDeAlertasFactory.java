package br.com.involves.selecao.factory;

import br.com.involves.selecao.builder.ControladorDeAlertasBuilder;

public class ControladorDeAlertasFactory {

    public ControladorDeAlertasBuilder getControladorDeAlertas() {
        return new ControladorDeAlertasBuilder();
    }
}
