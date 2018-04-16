package br.com.involves.selecao.principal;

import org.junit.Assert;
import org.junit.Test;

public class ProgramaTest {

    @Test
    public void testeSimplesDeSoma() {
        int resultadoExperado = 4;

        Programa programa = new Programa();
        int resultadoDoPrograma = programa.calculaDoisMaisDois();

        Assert.assertEquals(resultadoExperado, resultadoDoPrograma);
    }

}
