package br.com.involves.selecao.comando;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;
import br.com.involves.selecao.modelo.EntidadeCabecalho;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.RetornoComando;
import br.com.involves.selecao.parser.ParametroComandoParser;
import br.com.involves.selecao.parser.ParserParametroFiltrarPropriedade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ComandoHandlerFiltrarPropriedadeTest {

    private ComandoHandlerFiltrarPropriedade comandoHandlerFiltrarPropriedade;
    private EntidadeCabecalho cabecalho;

    @Before
    public void init() {
        ParametroComandoParser parser = new ParserParametroFiltrarPropriedade();

        comandoHandlerFiltrarPropriedade = new ComandoHandlerFiltrarPropriedade(parser);
        cabecalho = new EntidadeCabecalho(Arrays.asList("uf", "cidade"));
    }

    @Test
    public void testarComandoComValoresCorretos() {
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

        RetornoComando resultadoDoComando = comandoHandlerFiltrarPropriedade.exec("filter uf sc", dados);
        Assert.assertTrue(resultadoDoComando.toString().contains("sao jose"));
        Assert.assertTrue(resultadoDoComando.toString().contains("florianopolis"));
        Assert.assertTrue(resultadoDoComando.toString().contains("uf"));
    }

    @Test
    public void testarComandoComFiltroInvalido() {
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

        RetornoComando resultadoDoComando = comandoHandlerFiltrarPropriedade.exec("filter musica gospel", dados);
        Assert.assertTrue(resultadoDoComando.toString().contains("uf"));
        Assert.assertTrue(resultadoDoComando.toString().contains("cidade"));
    }

    @Test
    public void testarComandoComFiltroInexistente() {
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

        RetornoComando resultadoDoComando = comandoHandlerFiltrarPropriedade.exec("filter uf sp", dados);
        Assert.assertTrue(resultadoDoComando.toString().contains("uf"));
        Assert.assertTrue(resultadoDoComando.toString().contains("cidade"));
    }
}