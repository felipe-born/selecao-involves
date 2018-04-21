package br.com.involves.selecao.principal;

import br.com.involves.selecao.controlador.ControladorDaAplicacao;
import br.com.involves.selecao.controlador.ControladorDeAlertas;
import br.com.involves.selecao.fabrica.ControladorDaAplicacaoFactory;
import br.com.involves.selecao.fabrica.ControladorDeAlertasFactory;
import br.com.involves.selecao.fabrica.ControladorDeParametrosFactory;
import br.com.involves.selecao.modelo.Alerta;
import br.com.involves.selecao.modelo.ParametrosAplicacao;

import javax.swing.plaf.synth.SynthFormattedTextFieldUI;
import java.util.List;

public class InvolvesApp {

    private ParametrosAplicacao parametrosAplicacao;
    private ControladorDeAlertas controladorDeAlertas;
    private ControladorDaAplicacao controladorDaAplicacao;


    public InvolvesApp(String... args) {
        controladorDeAlertas = new ControladorDeAlertasFactory()
                .getControladorDeAlertas()
                .build();
        parametrosAplicacao = new ControladorDeParametrosFactory()
                .getControladorDeParametros()
                .comControladorDeAlertas(controladorDeAlertas)
                .comParametros(args)
                .build()
                .controle();
        controladorDaAplicacao = new ControladorDaAplicacaoFactory()
                .getControladorDaAplicacao()
                .comControladorDeAlertas(controladorDeAlertas)
                .comParametros(parametrosAplicacao)
                .comInputStream(System.in)
                .build();
    }

    public void run() {
        controladorDaAplicacao.inicializaAplicacao();
    }

    public String getParametroArquivo() {
        return parametrosAplicacao.getArquivo();
    }

    public List<Alerta> getAlertas() {
        return controladorDeAlertas.getAlertas();
    }
}
