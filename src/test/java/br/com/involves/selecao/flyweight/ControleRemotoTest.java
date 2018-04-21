package br.com.involves.selecao.flyweight;

import br.com.involves.selecao.comando.ComandoHandler;
import br.com.involves.selecao.comando.ComandoHandlerAjuda;
import br.com.involves.selecao.comando.ComandoHandlerFiltrarPropriedade;
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
        ComandoHandler instance = controleRemoto.getInstance(ComandoHandlerAjuda.class);
        Assert.assertNotNull(instance);
        Assert.assertTrue(instance instanceof ComandoHandlerAjuda);
    }

    @Test
    public void testeVerificarInstanciaClasseValidaComParametroConstrutor() {

        ControleRemoto controleRemoto = ControleRemoto.getInstancia();
        ComandoHandler instance = controleRemoto.getInstance(ComandoHandlerFiltrarPropriedade.class);
        Assert.assertNotNull(instance);
        Assert.assertTrue(instance instanceof ComandoHandlerFiltrarPropriedade);
    }
}