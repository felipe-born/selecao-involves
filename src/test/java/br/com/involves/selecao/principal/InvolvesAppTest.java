package br.com.involves.selecao.principal;

import br.com.involves.selecao.dominio.TipoDeParametro;
import br.com.involves.selecao.model.Alerta;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class InvolvesAppTest {

    @Test
    public void testConstrutorInvolveAppSemParametros() {
        InvolvesApp involvesApp = new InvolvesApp(new String[0]);
        expectDefaultParamsValues(involvesApp);
    }

    @Test
    public void testConstrutorInvolveAppComParametroNull() {
        InvolvesApp involvesApp = new InvolvesApp(null);
        expectDefaultParamsValues(involvesApp);
    }

    @Test
    public void testConstrutorInvolveComParametrosValidos() {
        InvolvesApp involvesApp = new InvolvesApp("--file=meuOutroArquivo.csv", "--ignorarErros=true");
        String valorEsperadoArquivo = "meuOutroArquivo.csv";
        boolean valorEsperadoIgnorarErro = true;

        assertInvolves(valorEsperadoArquivo, valorEsperadoIgnorarErro, involvesApp);
    }

    @Test
    public void testConstrutorInvolveComParametrosInvalidos() {
        InvolvesApp involvesApp = new InvolvesApp("--parametroEstranho=olá");
        List<Alerta> alertas = involvesApp.getAlertas();

        assertEquals(1, alertas.size());

        expectDefaultParamsValues(involvesApp);
    }

    private void expectDefaultParamsValues(InvolvesApp involvesApp) {
        String valorEsperadoArquivo = TipoDeParametro.PARAMETRO_ARQUIVO.getValorPadrao();
        boolean valorEsperadoIgnorarErro = Boolean.getBoolean(TipoDeParametro.PARAMETRO_IGNORAR_ERROS.getValorPadrao());

        assertInvolves(valorEsperadoArquivo, valorEsperadoIgnorarErro, involvesApp);
    }

    private void assertInvolves(String valorEsperadoArquivo, boolean valorEsperadoIgnorarErro, InvolvesApp involvesApp) {
        assertEquals(valorEsperadoArquivo, involvesApp.getParametroArquivo());
        assertEquals(valorEsperadoIgnorarErro, involvesApp.getParametroIgnorarErroDasLinhas());
    }

}
