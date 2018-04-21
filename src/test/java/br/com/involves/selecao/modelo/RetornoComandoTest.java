package br.com.involves.selecao.modelo;

import org.junit.Assert;
import org.junit.Test;

public class RetornoComandoTest {

    @Test
    public void testarEqualsHashCodeRetornoComando() {
        RetornoComando retornoComando1 = new RetornoComando("m1");
        RetornoComando retornoComando2 = new RetornoComando("m1");

        Assert.assertTrue(retornoComando1.equals(retornoComando2));
        Assert.assertTrue(retornoComando1.hashCode() == retornoComando2.hashCode());
    }

    @Test
    public void testarEqualsComObjetosIguais() {
        RetornoComando retornoComando = new RetornoComando("");
        Assert.assertTrue(retornoComando.equals(retornoComando));
    }

    @Test
    public void testarEqualsComClassesDiferentes() {
        RetornoComando retornoComando = new RetornoComando("");
        Assert.assertFalse(retornoComando.equals(""));
    }

    @Test
    public void testarEqualsComNulo() {
        RetornoComando retornoComando = new RetornoComando("");
        Assert.assertFalse(retornoComando.equals(null));
    }

}