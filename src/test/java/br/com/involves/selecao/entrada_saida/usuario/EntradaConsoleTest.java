package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;
import br.com.involves.selecao.conversor.ConversorConjuntoDadosComPropriedades;
import br.com.involves.selecao.fabrica.ControladorDeInterfaceDeUsuarioFactory;
import br.com.involves.selecao.flyweight.ControleRemoto;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class EntradaConsoleTest {

    private ControladorDeInterfaceDeUsuario interfaceDeUsuario;
    private EntradaConsole console;
    private InterfaceDeSaidaDeTeste interfaceDeSaidaDeTeste;

    @Before
    public void inicializa() {
        String comando = "help";
        new ByteArrayInputStream(comando.getBytes());

        console = new EntradaConsole();
        interfaceDeSaidaDeTeste = new InterfaceDeSaidaDeTeste();

        interfaceDeUsuario =
                new ControladorDeInterfaceDeUsuarioFactory()
                        .getControladorDeInterface()
                        .comInterfaceDeSaida(interfaceDeSaidaDeTeste)
                        .comInterfaceDeEntrada(console)
                        .comComandoFlyweight(ControleRemoto.getInstancia())
                        .comConversor(new ConversorConjuntoDadosComPropriedades())
                        //.comEntidades(entidadeDeLeituras)
                        .build();

    }

    @Test
    public void test() {

    }

}