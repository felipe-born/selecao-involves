package br.com.involves.selecao.parser;

import br.com.involves.selecao.excecao.ParametroParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ParserParametroFiltrarPropriedadeTest {

    private ParserParametroFiltrarPropriedade parser;

    @Before
    public void inicializaParser() {
        parser = new ParserParametroFiltrarPropriedade();
    }

    @Test
    public void testarParserComUnicoParametro() {
        List<String> resultadoParse = parser.parse("filter uf SC");
        Assert.assertEquals(2, resultadoParse.size());
        Assert.assertEquals("uf", resultadoParse.get(0));
        Assert.assertEquals("SC", resultadoParse.get(1));
    }

    @Test
    public void testarParserComParametrosEntreAspas() {
        List<String> resultadoParse = parser.parse("filter \"estado brasileiro\" \"santa catarina\"");
        Assert.assertEquals(2, resultadoParse.size());
        Assert.assertEquals("estado brasileiro", resultadoParse.get(0));
        Assert.assertEquals("santa catarina", resultadoParse.get(1));
    }

    @Test(expected = ParametroParserException.class)
    public void testarParserComMultiplosParametros() {
        parser.parse("filter codigo do ibge");
    }

    @Test(expected = NullPointerException.class)
    public void testarParserComParametroNulo() {
        parser.parse(null);
    }

    @Test(expected = ParametroParserException.class)
    public void testarParserSemParametro() {
        List<String> resultadoParse = parser.parse("filter");
    }

    @Test(expected = ParametroParserException.class)
    public void testarParserComComandoErrado() {
        parser.parse("filtrar uf sc");
    }
}