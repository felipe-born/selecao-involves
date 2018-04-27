package br.com.involves.selecao.modelo;

import org.junit.Assert;
import org.junit.Test;

public class PropriedadesTest {

    @Test
    public void testarMetodoPossuiPropriedadeComValorNulo() {
        Propriedades propriedades = new Propriedades();
        Assert.assertFalse(propriedades.possuiPropriedadeComValor("", null));
    }

    @Test
    public void testarMetodoPossuiPropriedadeComPropriedadeNulo() {
        Propriedades propriedades = new Propriedades();
        Assert.assertFalse(propriedades.possuiPropriedadeComValor(null, ""));
    }

}