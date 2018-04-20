package br.com.involves.selecao.comando;

import org.junit.Assert;
import org.junit.Test;

public class ComandoHandlerAjudaTest {

    @Test
    public void testarHandlerAjuda() {
        ComandoHandlerAjuda handlerAjuda = new ComandoHandlerAjuda();

        String saidaExecucaoNula = handlerAjuda.exec(null, null);
        String saidaExecucaoVazia = handlerAjuda.exec("", null);
        String saidaExecucaoComComando = handlerAjuda.exec("help", null);

        Assert.assertTrue(saidaExecucaoNula.equals(saidaExecucaoVazia));
        Assert.assertTrue(saidaExecucaoComComando.equals(saidaExecucaoNula));
    }

}