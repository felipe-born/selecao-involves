package br.com.involves.selecao.principal;

import org.junit.Test;

public class InvolvesAppTeste {

    @Test
    public void testConstrutorInvolveAppSemParametros() {
        new InvolvesApp(new String[0]);
    }

    @Test
    public void testConstrutorInvolveAppComParametroNull() {
        new InvolvesApp(null);
    }

}
