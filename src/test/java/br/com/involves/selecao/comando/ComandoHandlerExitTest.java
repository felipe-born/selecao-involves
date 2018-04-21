package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Test;

public class ComandoHandlerExitTest {

    @Test
    public void testarComandoSair() {
        ComandoHandlerExit comandoSaida = new ComandoHandlerExit();
        RetornoComando exit = comandoSaida.exec("exit", null);

        Assert.assertNotNull(exit);
        Assert.assertTrue(exit.indicaFimExecucao());
    }
}