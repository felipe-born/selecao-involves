package br.com.involves.selecao.validador;

import br.com.involves.selecao.excecao.ValidacaoException;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import org.junit.Before;
import org.junit.Test;

public class ValidadorDeParametrosAplicacaoTest {

    private ValidadorDeParametrosAplicacao validador;

    @Before
    public void inicializa() {
        validador = new ValidadorDeParametrosAplicacao();
    }

    @Test
    public void testeValicadaoComElementoValido() throws ValidacaoException {
        ParametrosAplicacao elementoValido = new ParametrosAplicacao("cidades.csv");
        validador.valida(elementoValido);
    }

    @Test(expected = ValidacaoException.class)
    public void testeValicadaoComElementoNulo() throws ValidacaoException {
        ParametrosAplicacao elementoValido = new ParametrosAplicacao(null);
        validador.valida(elementoValido);
    }

    @Test(expected = ValidacaoException.class)
    public void testeValicadaoComElementoVazio() throws ValidacaoException {
        ParametrosAplicacao elementoValido = new ParametrosAplicacao("");
        validador.valida(elementoValido);
    }
}