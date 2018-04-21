package br.com.involves.selecao.controlador;

import br.com.involves.selecao.builder.ControladorDaAplicacaoBuilder;
import br.com.involves.selecao.fabrica.ControladorDaAplicacaoFactory;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ControladorDaAplicacaoTest {

    private ControladorDaAplicacaoBuilder controladorDaAplicacaoBuilder;

    @Before
    public void inicializa() {
        InputStream exitInputStream = new ByteArrayInputStream("exit".getBytes());
        controladorDaAplicacaoBuilder = new ControladorDaAplicacaoFactory()
                .getControladorDaAplicacao()
                .comControladorDeAlertas(new ControladorDeAlertas())
                .comInputStream(exitInputStream)
        ;
    }

    @Test(expected = RuntimeException.class)
    public void inicializaConstrutorControladorComParametroVazio() {

        ControladorDaAplicacao controladorDaAplicacao = controladorDaAplicacaoBuilder
                .comParametros(new ParametrosAplicacao(""))
                .build();

        controladorDaAplicacao.inicializaAplicacao();
    }

    @Test(expected = RuntimeException.class)
    public void inicializaConstrutorControladorComParametroNulo() {

        ControladorDaAplicacao controladorDaAplicacao = controladorDaAplicacaoBuilder
                .comParametros(new ParametrosAplicacao(null))
                .build();

        controladorDaAplicacao.inicializaAplicacao();
    }

    @Test
    public void inicializaConstrutorControladorComParametroValido() {
        ControladorDaAplicacao controladorDaAplicacao = controladorDaAplicacaoBuilder
                .comParametros(new ParametrosAplicacao("cidades.csv"))
                .build();

        controladorDaAplicacao.inicializaAplicacao();
    }
}