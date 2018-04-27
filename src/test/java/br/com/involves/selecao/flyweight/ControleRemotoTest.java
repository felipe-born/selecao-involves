package br.com.involves.selecao.flyweight;

import br.com.involves.selecao.comando.Comando;
import br.com.involves.selecao.comando.ComandoAjuda;
import br.com.involves.selecao.comando.ComandoFiltragem;
import org.junit.Assert;
import org.junit.Test;

public class ControleRemotoTest {

    @Test
    public void testeVerificarSingleton() {
        ControleRemoto controleRemoto = ControleRemoto.getInstancia();
        Assert.assertNotNull(controleRemoto);

        ControleRemoto outraInstancia = ControleRemoto.getInstancia();

        Assert.assertEquals(controleRemoto, outraInstancia);
    }

    @Test
    public void testeVerificarInstanciaClasseValidaSemParametroConstrutor() {
        ControleRemoto controleRemoto = ControleRemoto.getInstancia();
        Comando instance = controleRemoto.getInstance(ComandoAjuda.class);
        Assert.assertNotNull(instance);
        Assert.assertTrue(instance instanceof ComandoAjuda);
    }

    @Test
    public void testeVerificarInstanciaClasseValidaComParametroConstrutor() {

        ControleRemoto controleRemoto = ControleRemoto.getInstancia();
        Comando instance = controleRemoto.getInstance(ComandoFiltragem.class);
        Assert.assertNotNull(instance);
        Assert.assertTrue(instance instanceof ComandoFiltragem);
    }
}