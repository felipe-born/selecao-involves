package br.com.involves.selecao.comando;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.modelo.DadosComPropriedade;
import br.com.involves.selecao.modelo.Cabecalho;
import br.com.involves.selecao.modelo.Propriedades;
import br.com.involves.selecao.modelo.RetornoComando;
import br.com.involves.selecao.parser.ParametroComandoParser;
import br.com.involves.selecao.parser.ParserParametroFiltrarPropriedade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ComandoFiltragemTest {

    private ComandoFiltragem comandoFiltragem;
    private Cabecalho cabecalho;

    @Before
    public void init() {
        ParametroComandoParser parser = new ParserParametroFiltrarPropriedade();

        comandoFiltragem = new ComandoFiltragem(parser);
        cabecalho = new Cabecalho(Arrays.asList("uf", "cidade"));
    }

    @Test
    public void testarComandoComValoresCorretos() {
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

        RetornoComando resultadoDoComando = comandoFiltragem.exec("filter uf sc", dados);
        Assert.assertTrue(resultadoDoComando.toString().contains("sao jose"));
        Assert.assertTrue(resultadoDoComando.toString().contains("florianopolis"));
        Assert.assertTrue(resultadoDoComando.toString().contains("uf"));
    }

    @Test
    public void testarComandoComFiltroInvalido() {
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

        RetornoComando resultadoDoComando = comandoFiltragem.exec("filter musica gospel", dados);
        Assert.assertTrue(resultadoDoComando.toString().contains("uf"));
        Assert.assertTrue(resultadoDoComando.toString().contains("cidade"));
    }

    @Test
    public void testarComandoComFiltroInexistente() {
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

        RetornoComando resultadoDoComando = comandoFiltragem.exec("filter uf sp", dados);
        Assert.assertTrue(resultadoDoComando.toString().contains("uf"));
        Assert.assertTrue(resultadoDoComando.toString().contains("cidade"));
    }
}