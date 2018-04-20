package br.com.involves.selecao.parser;

import br.com.involves.selecao.excecao.ParametroParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ParserParametroContarDistintosTest {

    private ParserParametroContarDistintos parserParametroContarDistintos;

    @Before
    public void inicializaParser() {
        parserParametroContarDistintos = new ParserParametroContarDistintos();
    }

    @Test
    public void testarParserComUnicoParametro() {
        List<String> resultadoParse = parserParametroContarDistintos.parse("count distinct uf");
        Assert.assertEquals(1, resultadoParse.size());
        Assert.assertEquals("uf", resultadoParse.get(0));
    }

    @Test
    public void testarParserComMultiplosParametros() {
        List<String> resultadoParse = parserParametroContarDistintos.parse("count distinct codigo do ibge");
        Assert.assertEquals(1, resultadoParse.size());
        Assert.assertEquals("codigo do ibge", resultadoParse.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testarParserComParametroNulo() {
        parserParametroContarDistintos.parse(null);
    }

    @Test
    public void testarParserSemParametro() {
        List<String> resultadoParse = parserParametroContarDistintos.parse("count distinct");
        Assert.assertEquals(1, resultadoParse.size());
        Assert.assertTrue(resultadoParse.get(0).isEmpty());
    }

    @Test(expected = ParametroParserException.class)
    public void testarParserComComandoErrado() {
        parserParametroContarDistintos.parse("count distintos");
    }

}