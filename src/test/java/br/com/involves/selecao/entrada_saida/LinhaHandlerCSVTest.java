package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import br.com.involves.selecao.modelo.EntidadeCabecalho;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LinhaHandlerCSVTest {

    private LinhaHandlerCSV linhaHandlerCSV;

    @Before
    public void inicializa() {
        this.linhaHandlerCSV = new LinhaHandlerCSV();
    }

    @Test
    public void testarCabecalhoComUmParametro() throws EntidadeDeLeituraException {
        String conteudo = "p1";
        EntidadeCabecalho cabecalho = getEntidadeCabecalho(conteudo);
        List<String> cabecalhoAsList = cabecalho.getCabecalhoAsList();

        Assert.assertEquals(1, cabecalhoAsList.size());
        Assert.assertEquals("p1", cabecalhoAsList.get(0));
    }

    @Test
    public void testarCabecalhoComMultiplosParametros() throws EntidadeDeLeituraException {
        String conteudo = "p1,p2,p3";

        EntidadeCabecalho cabecalho = getEntidadeCabecalho(conteudo);
        List<String> cabecalhoAsList = cabecalho.getCabecalhoAsList();

        Assert.assertEquals(3, cabecalhoAsList.size());
        Assert.assertTrue(cabecalho.contem("p1"));
        Assert.assertTrue(cabecalho.contem("p2"));
        Assert.assertTrue(cabecalho.contem("p3"));
    }

    @Test
    public void testarMultiplasLeituras() throws EntidadeDeLeituraException {
        String conteudoCabecalho = "p1,p2,p3";
        getEntidadeCabecalho(conteudoCabecalho);

        String conteudoLinha1 = "a,b,c";
        EntidadeComPropriedades entidade1 = getEntidadeComPropriedades(conteudoLinha1);
        entidade1.possuiPropriedadeComValor("p1", "a");
        entidade1.possuiPropriedadeComValor("p2", "b");
        entidade1.possuiPropriedadeComValor("p3", "c");

        String conteudoLinha2 = "d,e,f";
        EntidadeComPropriedades entidade2 = getEntidadeComPropriedades(conteudoLinha2);
        entidade2.possuiPropriedadeComValor("p1", "d");
        entidade2.possuiPropriedadeComValor("p2", "e");
        entidade2.possuiPropriedadeComValor("p3", "f");
    }

    @Test(expected = EntidadeDeLeituraException.class)
    public void testarLeituraComParametrosAMais() throws EntidadeDeLeituraException {
        String conteudoCabecalho = "p1,p2,p3";
        getEntidadeCabecalho(conteudoCabecalho);

        String conteudoLinha1 = "a,b,c,d";
        getEntidadeComPropriedades(conteudoLinha1);
    }

    @Test(expected = EntidadeDeLeituraException.class)
    public void testarLeituraComParametrosAMenos() throws EntidadeDeLeituraException {
        String conteudoCabecalho = "p1,p2,p3";
        getEntidadeCabecalho(conteudoCabecalho);

        String conteudoLinha1 = "a,b";
        getEntidadeComPropriedades(conteudoLinha1);
    }

    private EntidadeComPropriedades getEntidadeComPropriedades(String conteudo) throws EntidadeDeLeituraException {
        EntidadeDeLeitura entidadeDeLeitura = linhaHandlerCSV.lidarCom(conteudo);
        Assert.assertTrue(entidadeDeLeitura instanceof EntidadeComPropriedades);
        return (EntidadeComPropriedades) entidadeDeLeitura;
    }

    private EntidadeCabecalho getEntidadeCabecalho(String conteudo) throws EntidadeDeLeituraException {
        EntidadeDeLeitura entidadeDeLeitura = linhaHandlerCSV.lidarCom(conteudo);
        Assert.assertTrue(entidadeDeLeitura instanceof EntidadeCabecalho);
        return (EntidadeCabecalho) entidadeDeLeitura;
    }

}