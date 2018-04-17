package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorDaAplicacao;
import br.com.involves.selecao.controlador.ControladorDeAlertas;
import br.com.involves.selecao.model.ParametrosAplicacao;
import javafx.util.Builder;

public class ControladorDaAplicacaoBuilder implements Builder<ControladorDaAplicacao> {
    private ControladorDeAlertas controladorDeAlertas;
    private ParametrosAplicacao parametrosAplicacao;

    public ControladorDaAplicacaoBuilder comControladorDeAlertas(ControladorDeAlertas controladorDeAlertas) {
        this.controladorDeAlertas = controladorDeAlertas;
        return this;
    }

    public ControladorDaAplicacaoBuilder comParametros(ParametrosAplicacao parametrosAplicacao) {
        this.parametrosAplicacao = parametrosAplicacao;
        return this;
    }

    public ControladorDaAplicacao build() {
        return new ControladorDaAplicacao(controladorDeAlertas, parametrosAplicacao);
    }
}
