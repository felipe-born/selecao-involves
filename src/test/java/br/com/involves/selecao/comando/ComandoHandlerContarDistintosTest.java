package br.com.involves.selecao.comando;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;
import br.com.involves.selecao.modelo.EntidadeCabecalho;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.parser.ParametroComandoParser;
import br.com.involves.selecao.parser.ParserParametroContarDistintos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ComandoHandlerContarDistintosTest {

    ComandoHandlerContarDistintos handlerContarDistintos;
    EntidadeCabecalho cabecalho;

    @Before
    public void init() {
        ParametroComandoParser parser = new ParserParametroContarDistintos();
        handlerContarDistintos = new ComandoHandlerContarDistintos(parser);
        cabecalho = new EntidadeCabecalho(Arrays.asList("uf", "cidade"));
    }

    @Test
    public void testarContagemComValoresDistintos() {
        ConjuntoDadosComPropriedade dados = new ConjuntoDadosComPropriedade(cabecalho);

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

        dados.adiciona(entidadeFlorianopolis);
        dados.adiciona(entidadePoa);
        dados.adiciona(entidadeCuritiba);

        String resultadoComando = handlerContarDistintos.exec("count distinct uf", dados);

        Assert.assertEquals("3", resultadoComando);
    }

    @Test
    public void testarContagemComValoresRepetidos() {
        ConjuntoDadosComPropriedade dados = new ConjuntoDadosComPropriedade(cabecalho);

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

        dados.adiciona(entidadeFlorianopolis);
        dados.adiciona(entidadePoa);
        dados.adiciona(entidadeCuritiba);
        dados.adiciona(entidadeSaoJose);

        String resultadoComando = handlerContarDistintos.exec("count distinct uf", dados);

        Assert.assertEquals("3", resultadoComando);
    }

    @Test
    public void testarContagemComPropriedadeInexistente() {
        ConjuntoDadosComPropriedade dados = new ConjuntoDadosComPropriedade(cabecalho);

        EntidadeComPropriedades entidadeFlorianopolis = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("sc", "florianopolis")
                .build();

        dados.adiciona(entidadeFlorianopolis);

        String resultadoComando = handlerContarDistintos.exec("count distinct musica", dados);

        Assert.assertEquals("0", resultadoComando);
    }

    @Test
    public void testarContagemSemLinhasAlemDoCabecalho() {
        ConjuntoDadosComPropriedade dados = new ConjuntoDadosComPropriedade(cabecalho);

        String resultadoComando = handlerContarDistintos.exec("count distinct musica", dados);

        Assert.assertEquals("0", resultadoComando);
    }
}