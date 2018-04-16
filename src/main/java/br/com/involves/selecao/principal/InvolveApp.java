package br.com.involves.selecao.principal;

import br.com.involves.selecao.controlador.Controlador;
import br.com.involves.selecao.controlador.ControladorDeParametros;
import br.com.involves.selecao.model.ParametrosAplicacao;

public class InvolveApp {

    private Controlador<ParametrosAplicacao> controladorDeParametros;
    private ParametrosAplicacao parametrosAplicacao;


    public InvolveApp(String[] args) {
        controladorDeParametros = new ControladorDeParametros(args);
        parametrosAplicacao = controladorDeParametros.leia();
    }

    public void run() {
        System.out.println("Rodando com parâmetros!");
    }
}
