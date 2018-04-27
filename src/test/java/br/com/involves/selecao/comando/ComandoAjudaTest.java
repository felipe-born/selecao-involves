package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Assert;
import org.junit.Test;

public class ComandoAjudaTest {

    @Test
    public void testarHandlerAjuda() {
        ComandoAjuda handlerAjuda = new ComandoAjuda();

        RetornoComando saidaExecucaoNula = handlerAjuda.exec(null, null);
        RetornoComando saidaExecucaoVazia = handlerAjuda.exec("", null);
        RetornoComando saidaExecucaoComComando = handlerAjuda.exec("help", null);

        Assert.assertTrue(saidaExecucaoNula.equals(saidaExecucaoVazia));
        Assert.assertTrue(saidaExecucaoComComando.equals(saidaExecucaoNula));
    }

}