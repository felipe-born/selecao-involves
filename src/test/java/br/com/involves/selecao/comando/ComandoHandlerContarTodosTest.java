package br.com.involves.selecao.comando;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.conversor.ConversorConjuntoDadosComPropriedades;
import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;
import br.com.involves.selecao.modelo.EntidadeCabecalho;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ComandoHandlerContarTodosTest {

    private ComandoHandlerContarTodos comandoHandlerContarTodos;

    @Before
    public void init() {
        comandoHandlerContarTodos = new ComandoHandlerContarTodos();
    }

    @Test
    public void testarComandoContandoEntidadeValida() {
        ConversorConjuntoDadosComPropriedades conversorEntidadeParaEntradaComando = new ConversorConjuntoDadosComPropriedades();
        EntidadeComPropriedades entidadeA = new EntidadeComPropriedadesBuilder()
                .comPropriedades("p1", "p2", "p3")
                .comValores("a1", "a2", "a1")
                .build();
        EntidadeComPropriedades entidadeB = new EntidadeComPropriedadesBuilder()
                .comPropriedades("p1", "p2", "p3")
                .comValores("b1", "b2", "b1")
                .build();
        EntidadeComPropriedades entidadeC = new EntidadeComPropriedadesBuilder()
                .comPropriedades("p1", "p2", "p3")
                .comValores("c1", "c2", "c3")
                .build();

        List<EntidadeComPropriedades> entidadeComPropriedades = Arrays.asList(entidadeA, entidadeB, entidadeC);
        ConjuntoDadosComPropriedade entradaDeComando = conversorEntidadeParaEntradaComando.converter(entidadeComPropriedades);
        RetornoComando exec = comandoHandlerContarTodos.exec("count *", entradaDeComando);
        Assert.assertEquals("3", exec.toString());
    }

    @Test
    public void testarComandoContandoEntidadeApenasCabecalho() {
        Collection<String> cabecalhoCSV = Arrays.asList("p1", "p2", "p3");
        EntidadeCabecalho entidadeCabecalho = new EntidadeCabecalho(cabecalhoCSV);
        ConjuntoDadosComPropriedade entradaDeComando = new ConjuntoDadosComPropriedade(entidadeCabecalho);
        RetornoComando exec = comandoHandlerContarTodos.exec("count *", entradaDeComando);
        Assert.assertEquals("0", exec.toString());
    }

    @Test
    public void testarComandoComParametroNulo() {
        RetornoComando exec = comandoHandlerContarTodos.exec("count *", null);
        Assert.assertEquals("0", exec.toString());
    }

    @Test
    public void testarConversorComValorNulo() {
        ConversorConjuntoDadosComPropriedades conversorConjuntoDadosComPropriedades = new ConversorConjuntoDadosComPropriedades();

        ConjuntoDadosComPropriedade converter = conversorConjuntoDadosComPropriedades.converter(null);
        Assert.assertNull(converter);
        converter = conversorConjuntoDadosComPropriedades.converter(new ArrayList<>());
        Assert.assertNull(converter);

    }

}