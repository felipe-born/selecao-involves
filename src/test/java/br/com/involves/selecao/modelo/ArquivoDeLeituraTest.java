package br.com.involves.selecao.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ArquivoDeLeituraTest {

    @Test(expected = NullPointerException.class)
    public void testarArquivoLeituraComParametroNulo() {
        new ArquivoDeLeitura(null, null);
    }

    @Test
    public void testarArquivoLeituraComParametrosValidos() {
        ArquivoDeLeitura arquivoDeLeitura = new ArquivoDeLeitura("arquivo.csv", null);
        String extensao = arquivoDeLeitura.getExtensao();
        Assert.assertEquals("csv", extensao);
        Assert.assertEquals("arquivo.csv", arquivoDeLeitura.getCaminhoArquivo());
    }
}