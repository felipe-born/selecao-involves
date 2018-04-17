package br.com.involves.selecao.principal;

import br.com.involves.selecao.fabrica.ControladorDeParametrosFactory;
import br.com.involves.selecao.model.ParametrosAplicacao;

public class InvolveApp {

    private ParametrosAplicacao parametrosAplicacao;

    public InvolveApp(String[] args) {
        parametrosAplicacao = new ControladorDeParametrosFactory()
                .getControladorDeParametros()
                .comParametros(args)
                .build()
                .controle();
    }

    public void run() {
        System.out.println("Rodando com parâmetros!");
    }
}
