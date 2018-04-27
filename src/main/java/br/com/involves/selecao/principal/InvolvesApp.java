package br.com.involves.selecao.principal;

import br.com.involves.selecao.controlador.ControladorAplicacao;
import br.com.involves.selecao.controlador.ControladorAlertas;
import br.com.involves.selecao.factory.ControladorDaAplicacaoFactory;
import br.com.involves.selecao.factory.ControladorDeAlertasFactory;
import br.com.involves.selecao.factory.ControladorDeParametrosFactory;
import br.com.involves.selecao.modelo.Alerta;
import br.com.involves.selecao.modelo.ParametrosAplicacao;

import java.util.List;

public class InvolvesApp {

    private ParametrosAplicacao parametrosAplicacao;
    private ControladorAlertas controladorAlertas;
    private ControladorAplicacao controladorAplicacao;


    public InvolvesApp(String... args) {
        controladorAlertas = new ControladorDeAlertasFactory()
                .getControladorDeAlertas()
                .build();
        parametrosAplicacao = new ControladorDeParametrosFactory()
                .getControladorDeParametros()
                .comControladorDeAlertas(controladorAlertas)
                .comParametros(args)
                .build()
                .controle();
        controladorAplicacao = new ControladorDaAplicacaoFactory()
                .getControladorDaAplicacao()
                .comControladorDeAlertas(controladorAlertas)
                .comParametros(parametrosAplicacao)
                .comInputStream(System.in)
                .build();
    }

    public void run() {
        controladorAplicacao.inicializaAplicacao();
    }

    public String getParametroArquivo() {
        return parametrosAplicacao.getArquivo();
    }

    public List<Alerta> getAlertas() {
        return controladorAlertas.getAlertas();
    }
}
