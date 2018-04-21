package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;
import br.com.involves.selecao.conversor.ConversorConjuntoDadosComPropriedades;
import br.com.involves.selecao.fabrica.ControladorDeInterfaceDeUsuarioFactory;
import br.com.involves.selecao.flyweight.ControleRemoto;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class EntradaConsoleTest {

    private ControladorDeInterfaceDeUsuario interfaceDeUsuario;
    private EntradaConsole console;
    private InterfaceDeSaidaDeTeste interfaceDeSaidaDeTeste;

    @Before
    public void inicializa() {
        String comando = "exit";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(comando.getBytes());

        console = new EntradaConsole(inputStream);
        interfaceDeSaidaDeTeste = new InterfaceDeSaidaDeTeste();

        List<EntidadeDeLeitura> entidadeDeLeituras = new ArrayList<>();
        interfaceDeUsuario =
                new ControladorDeInterfaceDeUsuarioFactory()
                        .getControladorDeInterface()
                        .comInterfaceDeSaida(interfaceDeSaidaDeTeste)
                        .comInterfaceDeEntrada(console)
                        .comComandoFlyweight(ControleRemoto.getInstancia())
                        .comConversor(new ConversorConjuntoDadosComPropriedades())
                        .comEntidades(entidadeDeLeituras)
                        .build();

    }

    @Test
    public void testarEntradaDeComando() {
        this.console.recebeControlador(interfaceDeUsuario);
        this.console.aguardaEntrada();
    }

    @Test
    public void testarConstrutorConsoleComSystemIn() {
        this.console = new EntradaConsole(System.in);

        InputStream inputStream = console.getInputStream();

        Assert.assertEquals(System.in, inputStream);

    }

}