package br.com.involves.selecao.controlador;

import br.com.involves.selecao.builder.ControladorDaAplicacaoBuilder;
import br.com.involves.selecao.factory.ControladorDaAplicacaoFactory;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ControladorAplicacaoTest {

    private ControladorDaAplicacaoBuilder controladorDaAplicacaoBuilder;

    @Before
    public void inicializa() {
        InputStream exitInputStream = new ByteArrayInputStream("exit".getBytes());
        controladorDaAplicacaoBuilder = new ControladorDaAplicacaoFactory()
                .getControladorDaAplicacao()
                .comControladorDeAlertas(new ControladorAlertas())
                .comInputStream(exitInputStream)
        ;
    }

    @Test(expected = RuntimeException.class)
    public void inicializaConstrutorControladorComParametroVazio() {

        ControladorAplicacao controladorAplicacao = controladorDaAplicacaoBuilder
                .comParametros(new ParametrosAplicacao(""))
                .build();

        controladorAplicacao.inicializaAplicacao();
    }

    @Test(expected = RuntimeException.class)
    public void inicializaConstrutorControladorComParametroNulo() {

        ControladorAplicacao controladorAplicacao = controladorDaAplicacaoBuilder
                .comParametros(new ParametrosAplicacao(null))
                .build();

        controladorAplicacao.inicializaAplicacao();
    }

    @Test
    public void inicializaConstrutorControladorComParametroValido() {
        ControladorAplicacao controladorAplicacao = controladorDaAplicacaoBuilder
                .comParametros(new ParametrosAplicacao("cidades.csv"))
                .build();

        controladorAplicacao.inicializaAplicacao();
    }
}