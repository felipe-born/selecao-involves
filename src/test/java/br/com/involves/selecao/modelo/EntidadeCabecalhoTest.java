package br.com.involves.selecao.modelo;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import org.junit.Test;

import java.util.ArrayList;

public class EntidadeCabecalhoTest {


    @Test(expected = EntidadeDeLeituraException.class)
    public void testaConstrutorParametroNulo() {
        new EntidadeCabecalho(null);
    }

    @Test(expected = EntidadeDeLeituraException.class)
    public void testaConstrutorParametroVazio() {
        new EntidadeCabecalho(new ArrayList<>());
    }
}