package br.com.involves.selecao.comando;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.conversor.ConversorDadosComPropriedades;
import br.com.involves.selecao.modelo.DadosComPropriedade;
import br.com.involves.selecao.modelo.Cabecalho;
import br.com.involves.selecao.modelo.Propriedades;
import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ComandoContarTodosTest {

    private ComandoContarTodos comandoContarTodos;

    @Before
    public void init() {
        comandoContarTodos = new ComandoContarTodos();
    }

    @Test
    public void testarComandoContandoEntidadeValida() {
        ConversorDadosComPropriedades conversorEntidadeParaEntradaComando = new ConversorDadosComPropriedades();
        Propriedades entidadeA = new EntidadeComPropriedadesBuilder()
                .comPropriedades("p1", "p2", "p3")
                .comValores("a1", "a2", "a1")
                .build();
        Propriedades entidadeB = new EntidadeComPropriedadesBuilder()
                .comPropriedades("p1", "p2", "p3")
                .comValores("b1", "b2", "b1")
                .build();
        Propriedades entidadeC = new EntidadeComPropriedadesBuilder()
                .comPropriedades("p1", "p2", "p3")
                .comValores("c1", "c2", "c3")
                .build();

        List<Propriedades> propriedades = Arrays.asList(entidadeA, entidadeB, entidadeC);
        DadosComPropriedade entradaDeComando = conversorEntidadeParaEntradaComando.converter(propriedades);
        RetornoComando exec = comandoContarTodos.exec("count *", entradaDeComando);
        Assert.assertEquals("3", exec.toString());
    }

    @Test
    public void testarComandoContandoEntidadeApenasCabecalho() {
        Collection<String> cabecalhoCSV = Arrays.asList("p1", "p2", "p3");
        Cabecalho cabecalho = new Cabecalho(cabecalhoCSV);
        DadosComPropriedade entradaDeComando = new DadosComPropriedade(cabecalho);
        RetornoComando exec = comandoContarTodos.exec("count *", entradaDeComando);
        Assert.assertEquals("0", exec.toString());
    }

    @Test
    public void testarComandoComParametroNulo() {
        RetornoComando exec = comandoContarTodos.exec("count *", null);
        Assert.assertEquals("0", exec.toString());
    }

    @Test
    public void testarConversorComValorNulo() {
        ConversorDadosComPropriedades conversorDadosComPropriedades = new ConversorDadosComPropriedades();

        DadosComPropriedade converter = conversorDadosComPropriedades.converter(null);
        Assert.assertNull(converter);
        converter = conversorDadosComPropriedades.converter(new ArrayList<>());
        Assert.assertNull(converter);

    }

}