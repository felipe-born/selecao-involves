package br.com.involves.selecao.controlador;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.comando.Comando;
import br.com.involves.selecao.comando.ComandoAjuda;
import br.com.involves.selecao.conversor.ConversorDadosComPropriedades;
import br.com.involves.selecao.entrada_saida.usuario.TesteEntradaIU;
import br.com.involves.selecao.entrada_saida.usuario.TesteSaidaIU;
import br.com.involves.selecao.fabrica.ControladorDeInterfaceDeUsuarioFactory;
import br.com.involves.selecao.flyweight.ControleRemoto;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.Propriedades;
import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ControladorInterfaceDeUsuarioTest {

    private ControladorInterfaceDeUsuario interfaceDeUsuario;
    private TesteEntradaIU interfaceDeEntradaDeTeste;
    private TesteSaidaIU interfaceDeSaidaDeTeste;

    @Before
    public void inicializa() {
        List<EntidadeDeLeitura> entidadeDeLeituras = new ArrayList<>();

        Propriedades entidadeFlorianopolis = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("sc", "florianopolis")
                .build();
        Propriedades entidadePoa = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("rs", "porto alegre")
                .build();
        Propriedades entidadeCuritiba = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("pr", "curitiba")
                .build();
        Propriedades entidadeSaoJose = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("sc", "sao jose")
                .build();

        entidadeDeLeituras.add(entidadeFlorianopolis);
        entidadeDeLeituras.add(entidadePoa);
        entidadeDeLeituras.add(entidadeCuritiba);
        entidadeDeLeituras.add(entidadeSaoJose);

        interfaceDeEntradaDeTeste = new TesteEntradaIU();
        interfaceDeSaidaDeTeste = new TesteSaidaIU();

        interfaceDeUsuario =
                new ControladorDeInterfaceDeUsuarioFactory()
                        .getControladorDeInterface()
                        .comInterfaceDeSaida(interfaceDeSaidaDeTeste)
                        .comInterfaceDeEntrada(interfaceDeEntradaDeTeste)
                        .comComandoFlyweight(ControleRemoto.getInstancia())
                        .comConversor(new ConversorDadosComPropriedades())
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

        Comando comandoAjuda = ControleRemoto.getInstancia().getInstance(ComandoAjuda.class);
        RetornoComando resultadoDeAjuda = comandoAjuda.exec(null, null);

        Assert.assertTrue(interfaceDeSaidaDeTeste.estaComResultado(resultadoDeAjuda.toString()));
    }

}