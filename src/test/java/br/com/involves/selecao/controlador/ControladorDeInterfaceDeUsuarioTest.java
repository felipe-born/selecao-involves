package br.com.involves.selecao.controlador;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.comando.ComandoHandler;
import br.com.involves.selecao.comando.ComandoHandlerAjuda;
import br.com.involves.selecao.conversor.ConversorConjuntoDadosComPropriedades;
import br.com.involves.selecao.entrada_saida.usuario.InterfaceDeEntradaDeTeste;
import br.com.involves.selecao.entrada_saida.usuario.InterfaceDeSaidaDeTeste;
import br.com.involves.selecao.fabrica.ControladorDeInterfaceDeUsuarioFactory;
import br.com.involves.selecao.flyweight.ControleRemoto;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeInterfaceDeUsuarioTest {

    private ControladorDeInterfaceDeUsuario interfaceDeUsuario;
    private InterfaceDeEntradaDeTeste interfaceDeEntradaDeTeste;
    private InterfaceDeSaidaDeTeste interfaceDeSaidaDeTeste;

    @Before
    public void inicializa() {
        List<EntidadeDeLeitura> entidadeDeLeituras = new ArrayList<>();

        EntidadeComPropriedades entidadeFlorianopolis = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("sc", "florianopolis")
                .build();
        EntidadeComPropriedades entidadePoa = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("rs", "porto alegre")
                .build();
        EntidadeComPropriedades entidadeCuritiba = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("pr", "curitiba")
                .build();
        EntidadeComPropriedades entidadeSaoJose = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("sc", "sao jose")
                .build();

        entidadeDeLeituras.add(entidadeFlorianopolis);
        entidadeDeLeituras.add(entidadePoa);
        entidadeDeLeituras.add(entidadeCuritiba);
        entidadeDeLeituras.add(entidadeSaoJose);

        interfaceDeEntradaDeTeste = new InterfaceDeEntradaDeTeste();
        interfaceDeSaidaDeTeste = new InterfaceDeSaidaDeTeste();

        interfaceDeUsuario =
                new ControladorDeInterfaceDeUsuarioFactory()
                        .getControladorDeInterface()
                        .comInterfaceDeSaida(interfaceDeSaidaDeTeste)
                        .comInterfaceDeEntrada(interfaceDeEntradaDeTeste)
                        .comComandoFlyweight(ControleRemoto.getInstancia())
                        .comConversor(new ConversorConjuntoDadosComPropriedades())
                        .comEntidades(entidadeDeLeituras)
                        .build();
    }

    @Test
    public void testarInterfaceRecebendoComandoValido() {
        interfaceDeUsuario.iniciaComunicacaoComUsuario();
        interfaceDeUsuario.recebeComando("count *");

        Assert.assertTrue(interfaceDeSaidaDeTeste.estaComResultado("4"));
    }

    @Test
    public void testarInterfaceRecebendoComandoInvalido() {
        interfaceDeUsuario.iniciaComunicacaoComUsuario();
        interfaceDeUsuario.recebeComando("comando invalido");

        ComandoHandler comandoAjuda = ControleRemoto.getInstancia().getInstance(ComandoHandlerAjuda.class);
        String resultadoDeAjuda = comandoAjuda.exec(null, null);

        Assert.assertTrue(interfaceDeSaidaDeTeste.estaComResultado(resultadoDeAjuda));
    }

}