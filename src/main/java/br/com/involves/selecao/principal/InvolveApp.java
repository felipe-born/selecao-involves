package br.com.involves.selecao.principal;

import br.com.involves.selecao.controlador.Controlador;
import br.com.involves.selecao.controlador.ControladorDeParametros;

public class InvolveApp {

    private ControladorDeParametros controladorDeParametros;

    public InvolveApp(String[] args) {
        controladorDeParametros = new ControladorDeParametros();
        controladorDeParametros.leiaParametros(args);

    }

    public void run() {

    }
}
