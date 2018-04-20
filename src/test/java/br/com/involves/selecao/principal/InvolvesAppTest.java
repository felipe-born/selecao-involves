package br.com.involves.selecao.principal;

import br.com.involves.selecao.dominio.TipoDeParametro;
import br.com.involves.selecao.modelo.Alerta;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


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
        InvolvesApp involvesApp = new InvolvesApp("--file=meuOutroArquivo.csv");
        String valorEsperadoArquivo = "meuOutroArquivo.csv";

        assertInvolves(valorEsperadoArquivo, involvesApp);
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

        assertInvolves(valorEsperadoArquivo, involvesApp);
    }

    private void assertInvolves(String valorEsperadoArquivo, InvolvesApp involvesApp) {
        assertEquals(valorEsperadoArquivo, involvesApp.getParametroArquivo());
    }

}
