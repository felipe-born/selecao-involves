package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorDeAlertas;
import javafx.util.Builder;

public class ControladorDeAlertasBuilder implements Builder<ControladorDeAlertas> {
    @Override
    public ControladorDeAlertas build() {
        return new ControladorDeAlertas();
    }
}
