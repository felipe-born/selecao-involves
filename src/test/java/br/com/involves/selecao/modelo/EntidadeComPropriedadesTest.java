package br.com.involves.selecao.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EntidadeComPropriedadesTest {

    @Test
    public void testarMetodoPossuiPropriedadeComValorNulo() {
        EntidadeComPropriedades entidadeComPropriedades = new EntidadeComPropriedades();
        Assert.assertFalse(entidadeComPropriedades.possuiPropriedadeComValor("", null));
    }

    @Test
    public void testarMetodoPossuiPropriedadeComPropriedadeNulo() {
        EntidadeComPropriedades entidadeComPropriedades = new EntidadeComPropriedades();
        Assert.assertFalse(entidadeComPropriedades.possuiPropriedadeComValor(null, ""));
    }

}