package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.Controlador;
import br.com.involves.selecao.controlador.ControladorDeAlertas;
import br.com.involves.selecao.controlador.ControladorDeParametrosAplicacao;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import javafx.util.Builder;

public class ControladorDeParametrosAplicacaoBuilder implements Builder<Controlador<ParametrosAplicacao>> {

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

    public Controlador<ParametrosAplicacao> build() {
        return new ControladorDeParametrosAplicacao(parametros, controladorDeAlertas);
    }
}
