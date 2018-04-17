package br.com.involves.selecao.fabrica;

import br.com.involves.selecao.builder.ControladorDeAlertasBuilder;

public class ControladorDeAlertasFactory {

    public ControladorDeAlertasBuilder getControladorDeAlertas() {
        return new ControladorDeAlertasBuilder();
    }
}
