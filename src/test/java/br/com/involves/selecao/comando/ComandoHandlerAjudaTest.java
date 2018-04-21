package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Test;

public class ComandoHandlerAjudaTest {

    @Test
    public void testarHandlerAjuda() {
        ComandoHandlerAjuda handlerAjuda = new ComandoHandlerAjuda();

        RetornoComando saidaExecucaoNula = handlerAjuda.exec(null, null);
        RetornoComando saidaExecucaoVazia = handlerAjuda.exec("", null);
        RetornoComando saidaExecucaoComComando = handlerAjuda.exec("help", null);

        Assert.assertTrue(saidaExecucaoNula.equals(saidaExecucaoVazia));
        Assert.assertTrue(saidaExecucaoComComando.equals(saidaExecucaoNula));
    }

}