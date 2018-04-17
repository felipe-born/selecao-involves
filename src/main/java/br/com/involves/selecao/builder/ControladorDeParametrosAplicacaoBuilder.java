package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.Controlador;
import br.com.involves.selecao.controlador.ControladorDeParametrosAplicacao;
import br.com.involves.selecao.model.ParametrosAplicacao;
import javafx.util.Builder;

public class ControladorDeParametrosAplicacaoBuilder implements Builder<Controlador<ParametrosAplicacao>> {

    private String[] parametros;

    public ControladorDeParametrosAplicacaoBuilder comParametros(String[] parametros) {
        this.parametros = parametros;
        return this;
    }

    public Controlador<ParametrosAplicacao> build() {
        return new ControladorDeParametrosAplicacao(parametros);
    }
}
