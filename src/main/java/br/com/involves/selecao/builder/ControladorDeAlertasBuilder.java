package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorAlertas;
import javafx.util.Builder;

public class ControladorDeAlertasBuilder implements Builder<ControladorAlertas> {
    @Override
    public ControladorAlertas build() {
        return new ControladorAlertas();
    }
}
