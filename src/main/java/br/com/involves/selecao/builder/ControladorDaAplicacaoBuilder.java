package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorAplicacao;
import br.com.involves.selecao.controlador.ControladorAlertas;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import javafx.util.Builder;

import java.io.InputStream;

public class ControladorDaAplicacaoBuilder implements Builder<ControladorAplicacao> {
    private ControladorAlertas controladorAlertas;
    private ParametrosAplicacao parametrosAplicacao;
    private InputStream inputStream;

    public ControladorDaAplicacaoBuilder comControladorDeAlertas(ControladorAlertas controladorAlertas) {
        this.controladorAlertas = controladorAlertas;
        return this;
    }

    public ControladorDaAplicacaoBuilder comParametros(ParametrosAplicacao parametrosAplicacao) {
        this.parametrosAplicacao = parametrosAplicacao;
        return this;
    }

    public ControladorDaAplicacaoBuilder comInputStream(InputStream inputStream) {

        this.inputStream = inputStream;
        return this;
    }

    public ControladorAplicacao build() {
        return new ControladorAplicacao(controladorAlertas, parametrosAplicacao, inputStream);
    }
}
