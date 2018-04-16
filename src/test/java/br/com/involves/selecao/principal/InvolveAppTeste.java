package br.com.involves.selecao.principal;

import org.junit.Test;

public class InvolveAppTeste {

    @Test
    public void testConstrutorInvolveAppSemParametros() {
        InvolveApp app = new InvolveApp(new String[0]);
    }

    @Test
    public void testConstrutorInvolveAppComParametroNull() {
        InvolveApp app = new InvolveApp(null);
    }

}
