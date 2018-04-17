package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.Controlador;
import br.com.involves.selecao.controlador.ControladorDeParametros;
import br.com.involves.selecao.model.ParametrosAplicacao;
import javafx.util.Builder;

public class ControladorDeParametrosBuilder implements Builder<Controlador<ParametrosAplicacao>> {

    private String[] parametros;

    public ControladorDeParametrosBuilder comParametros(String[] parametros) {
        this.parametros = parametros;
        return this;
    }

    public Controlador<ParametrosAplicacao> build() {
        return new ControladorDeParametros(parametros);
    }
}
