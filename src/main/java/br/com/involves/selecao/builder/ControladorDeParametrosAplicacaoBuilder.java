package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorAlertas;
import br.com.involves.selecao.controlador.ControladorParametros;
import javafx.util.Builder;

public class ControladorDeParametrosAplicacaoBuilder implements Builder<ControladorParametros> {

    private String[] parametros;
    private ControladorAlertas controladorAlertas;

    public ControladorDeParametrosAplicacaoBuilder comParametros(String[] parametros) {
        this.parametros = parametros == null ? new String[0] : parametros;
        return this;
    }

    public ControladorDeParametrosAplicacaoBuilder comControladorDeAlertas(ControladorAlertas controladorAlertas) {
        this.controladorAlertas = controladorAlertas;
        return this;
    }

    public ControladorParametros build() {
        return new ControladorParametros(parametros, controladorAlertas);
    }
}
