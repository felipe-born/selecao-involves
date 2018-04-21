package br.com.involves.selecao.dominio;

import br.com.involves.selecao.entrada_saida.LinhaHandler;
import br.com.involves.selecao.entrada_saida.LinhaHandlerCSV;
import org.junit.Assert;
import org.junit.Test;

public class TipoDeArquivoTest {

    @Test
    public void testarTipoDeArquivoCSV() {
        TipoDeArquivo csv = TipoDeArquivo.getTipoDeArquivo("csv");
        Assert.assertNotNull(csv);
        LinhaHandler linhaHandler = csv.getLinhaHandler();
        Assert.assertNotNull(linhaHandler);
        Assert.assertTrue(linhaHandler instanceof LinhaHandlerCSV);

    }

    @Test
    public void testarTipoDeArquivoInexistente() {
        TipoDeArquivo csv = TipoDeArquivo.getTipoDeArquivo("inexistente");
        Assert.assertNull(csv);
    }



}