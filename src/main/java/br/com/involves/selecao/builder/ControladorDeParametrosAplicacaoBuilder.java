package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorDeAlertas;
import br.com.involves.selecao.controlador.ControladorDeParametrosAplicacao;
import javafx.util.Builder;

public class ControladorDeParametrosAplicacaoBuilder implements Builder<ControladorDeParametrosAplicacao> {

    private String[] parametros;
    private ControladorDeAlertas controladorDeAlertas;

    public ControladorDeParametrosAplicacaoBuilder comParametros(String[] parametros) {
        this.parametros = parametros == null ? new String[0] : parametros;
        return this;
    }

    public ControladorDeParametrosAplicacaoBuilder comControladorDeAlertas(ControladorDeAlertas controladorDeAlertas) {
        this.controladorDeAlertas = controladorDeAlertas;
        return this;
    }

    public ControladorDeParametrosAplicacao build() {
        return new ControladorDeParametrosAplicacao(parametros, controladorDeAlertas);
    }
}
