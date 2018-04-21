package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.builder.LeitorDeArquivoBuilder;
import br.com.involves.selecao.excecao.LeituraDeArquivoException;
import br.com.involves.selecao.excecao.TipoDeArquivoNaoSuportadoException;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class LeitorDeArquivoTest {

    private LeitorDeArquivo leitorDeArquivo;

    @Before
    public void inicializa() throws FileNotFoundException {
        this.leitorDeArquivo = getLeitor("cidades.csv");
    }

    @Test
    public void leiaArquivoExistenteCorreto() throws LeituraDeArquivoException {

        List<EntidadeDeLeitura> entidades = leitorDeArquivo.leia();
        Assert.assertEquals(5, entidades.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void leiaArquivoInexistente() throws LeituraDeArquivoException, FileNotFoundException {
        LeitorDeArquivo leitor = getLeitor("arquivo_inexistente.csv");
        leitor.leia();
    }

    @Test(expected = TipoDeArquivoNaoSuportadoException.class)
    public void leiaArquivoComTipoIndisponivel() throws LeituraDeArquivoException, FileNotFoundException {
        LeitorDeArquivo leitor = getLeitor("arquivo_inexistente.inexistente");
        leitor.leia();
    }

    @Test(expected = LeituraDeArquivoException.class)
    public void testarArquivoComStreamInvalido() throws LeituraDeArquivoException {
        ArquivoDeLeitura arquivoDeLeitura = new ArquivoDeLeitura("cidades.csv", null);

        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo(new LinhaHandlerCSV(), arquivoDeLeitura);

        leitorDeArquivo.leia();
    }

    private LeitorDeArquivo getLeitor(String arquivo) throws FileNotFoundException {
        ParametrosAplicacao parametrosAplicacao = new ParametrosAplicacao(arquivo);
        LeitorDeArquivoBuilder builder = new LeitorDeArquivoBuilder(parametrosAplicacao);
        return builder.build();
    }

}