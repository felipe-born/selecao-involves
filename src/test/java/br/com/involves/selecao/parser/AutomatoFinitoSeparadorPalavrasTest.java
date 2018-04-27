package br.com.involves.selecao.parser;

import br.com.involves.selecao.excecao.ParametroParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutomatoFinitoSeparadorPalavrasTest {

    private AutomatoFinitoSeparadorPalavras separadorPalavras;
    private String textoDelimitador = "\"", textoSeparador = " ";

    @Before
    public void init() {
        separadorPalavras = new AutomatoFinitoSeparadorPalavras();
    }

    @Test
    public void separaPalavrasSemDelimitador() {
        String texto = "ab cd ef";
        String[] palavrasSeparadas = separadorPalavras.separaPalavras(texto, textoDelimitador, textoSeparador);

        String[] valorEsperado = {"ab", "cd", "ef"};
        Assert.assertArrayEquals(valorEsperado, palavrasSeparadas);
    }

    @Test
    public void separaPalavrasComDelimitador() {
        String texto = "ab cd ef\"gh\"i";
        String[] palavrasSeparadas = separadorPalavras.separaPalavras(texto, textoDelimitador, textoSeparador);

        String[] valorEsperado = {"ab", "cd", "ef", "gh", "i"};
        Assert.assertArrayEquals(valorEsperado, palavrasSeparadas);
    }

    @Test(expected = ParametroParserException.class)
    public void separaPalavrasComDelimitadorIncompleto() {
        String texto = "ab cd ef\"ghi";
        String[] palavrasSeparadas = separadorPalavras.separaPalavras(texto, textoDelimitador, textoSeparador);

        String[] valorEsperado = {"ab", "cd", "ef", "gh", "i"};
        Assert.assertArrayEquals(valorEsperado, palavrasSeparadas);
    }

    @Test
    public void testarSeparadorComParametrosNulos() {
        String[] palavras = separadorPalavras.separaPalavras(null, textoDelimitador, textoSeparador);
        Assert.assertEquals(0, palavras.length);

        palavras = separadorPalavras.separaPalavras("abc", null, textoSeparador);
        Assert.assertEquals(0, palavras.length);

        palavras = separadorPalavras.separaPalavras("abc", textoDelimitador, null);
        Assert.assertEquals(0, palavras.length);

    }

}