package br.com.involves.selecao.comando;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.modelo.DadosComPropriedade;
import br.com.involves.selecao.modelo.Cabecalho;
import br.com.involves.selecao.modelo.Propriedades;
import br.com.involves.selecao.modelo.RetornoComando;
import br.com.involves.selecao.parser.ParametroComandoParser;
import br.com.involves.selecao.parser.ParserParametroContarDistintos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ComandoContarDistintosTest {

    ComandoContarDistintos handlerContarDistintos;
    Cabecalho cabecalho;

    @Before
    public void init() {
        ParametroComandoParser parser = new ParserParametroContarDistintos();
        handlerContarDistintos = new ComandoContarDistintos(parser);
        cabecalho = new Cabecalho(Arrays.asList("uf", "cidade"));
    }

    @Test
    public void testarContagemComValoresDistintos() {
        DadosComPropriedade dados = new DadosComPropriedade(cabecalho);

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

        dados.adiciona(entidadeFlorianopolis);
        dados.adiciona(entidadePoa);
        dados.adiciona(entidadeCuritiba);

        RetornoComando resultadoComando = handlerContarDistintos.exec("count distinct uf", dados);

        Assert.assertEquals("3", resultadoComando.toString());
    }

    @Test
    public void testarContagemComValoresRepetidos() {
        DadosComPropriedade dados = new DadosComPropriedade(cabecalho);

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

        dados.adiciona(entidadeFlorianopolis);
        dados.adiciona(entidadePoa);
        dados.adiciona(entidadeCuritiba);
        dados.adiciona(entidadeSaoJose);

        RetornoComando resultadoComando = handlerContarDistintos.exec("count distinct uf", dados);

        Assert.assertEquals("3", resultadoComando.toString());
    }

    @Test
    public void testarContagemComPropriedadeInexistente() {
        DadosComPropriedade dados = new DadosComPropriedade(cabecalho);

        Propriedades entidadeFlorianopolis = new EntidadeComPropriedadesBuilder()
                .comPropriedades("uf", "cidade")
                .comValores("sc", "florianopolis")
                .build();

        dados.adiciona(entidadeFlorianopolis);

        RetornoComando resultadoComando = handlerContarDistintos.exec("count distinct musica", dados);

        Assert.assertEquals("0", resultadoComando.toString());
    }

    @Test
    public void testarContagemSemLinhasAlemDoCabecalho() {
        DadosComPropriedade dados = new DadosComPropriedade(cabecalho);

        RetornoComando resultadoComando = handlerContarDistintos.exec("count distinct musica", dados);

        Assert.assertEquals("0", resultadoComando.toString());
    }
}