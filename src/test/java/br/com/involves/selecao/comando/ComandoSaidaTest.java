package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Test;

public class ComandoSaidaTest {

    @Test
    public void testarComandoSair() {
        ComandoSaida comandoSaida = new ComandoSaida();
        RetornoComando exit = comandoSaida.exec("exit", null);

        Assert.assertNotNull(exit);
        Assert.assertTrue(exit.indicaFimExecucao());
    }
}