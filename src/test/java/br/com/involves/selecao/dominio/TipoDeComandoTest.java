package br.com.involves.selecao.dominio;

import br.com.involves.selecao.comando.ComandoHandlerAjuda;
import br.com.involves.selecao.comando.ComandoHandlerFiltrarPropriedade;
import br.com.involves.selecao.comando.ConstantesComando;
import org.junit.Assert;
import org.junit.Test;

public class TipoDeComandoTest {

    @Test
    public void testarTipoDeComandoValido() {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom("filter uf sc");
        Assert.assertNotNull(tipoDeComando);
        Assert.assertEquals(ComandoHandlerFiltrarPropriedade.class, tipoDeComando.getHandlerClazz());
    }

    @Test
    public void testarTipoDeComandoInvalido() {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom("filtrar");
        Assert.assertNotNull(tipoDeComando);
        Assert.assertEquals(ComandoHandlerAjuda.class, tipoDeComando.getHandlerClazz());
    }

    @Test
    public void testarTipoDeComandoNulo() {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom(null);
        Assert.assertNotNull(tipoDeComando);
        Assert.assertEquals(ComandoHandlerAjuda.class, tipoDeComando.getHandlerClazz());
        Assert.assertEquals(tipoDeComando.toString(), ConstantesComando.CM_AJUDA);
    }

}