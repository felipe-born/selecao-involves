package br.com.involves.selecao.dominio;

import br.com.involves.selecao.comando.ComandoAjuda;
import br.com.involves.selecao.comando.ComandoFiltragem;
import br.com.involves.selecao.comando.ConstantesComando;
import org.junit.Assert;
import org.junit.Test;

public class TipoDeComandoTest {

    @Test
    public void testarTipoDeComandoValido() {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom("filter uf sc");
        Assert.assertNotNull(tipoDeComando);
        Assert.assertEquals(ComandoFiltragem.class, tipoDeComando.getHandlerClazz());
    }

    @Test
    public void testarTipoDeComandoInvalido() {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom("filtrar");
        Assert.assertNotNull(tipoDeComando);
        Assert.assertEquals(ComandoAjuda.class, tipoDeComando.getHandlerClazz());
    }

    @Test
    public void testarTipoDeComandoNulo() {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom(null);
        Assert.assertNotNull(tipoDeComando);
        Assert.assertEquals(ComandoAjuda.class, tipoDeComando.getHandlerClazz());
        Assert.assertEquals(tipoDeComando.toString(), ConstantesComando.CM_AJUDA);
    }

}