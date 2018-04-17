package br.com.involves.selecao.controlador;

import br.com.involves.selecao.model.ParametrosAplicacao;

public class ControladorDeParametros implements Controlador<ParametrosAplicacao> {
    private String[] parametros;

    public ControladorDeParametros(String[] parametros) {

        this.parametros = parametros;
    }

    public ParametrosAplicacao controle() {
        return null;
    }
}


