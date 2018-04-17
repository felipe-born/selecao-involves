package br.com.involves.selecao.principal;

import br.com.involves.selecao.fabrica.ControladorDeParametrosFactory;
import br.com.involves.selecao.model.ParametrosAplicacao;

public class InvolvesApp {

    private ParametrosAplicacao parametrosAplicacao;

    public InvolvesApp(String... args) {
        if(args == null)
            args = new String[0];
        parametrosAplicacao = new ControladorDeParametrosFactory()
                .getControladorDeParametros()
                .comParametros(args)
                .build()
                .controle();
    }

    public void run() {
        System.out.println("========================Involves APP========================");
        System.out.println("==========Felipe Born de Jesus __ Futuro Involvido==========");
        System.out.println(parametrosAplicacao);
    }

    public String getParametroArquivo() {
        return parametrosAplicacao.getArquivo();
    }

    public boolean getParametroIgnorarErroDasLinhas() {
        return parametrosAplicacao.isIgnorarErrosDasLinhas();
    }
}
