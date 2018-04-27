package br.com.involves.selecao.modelo;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import org.junit.Test;

import java.util.ArrayList;

public class CabecalhoTest {


    @Test(expected = EntidadeDeLeituraException.class)
    public void testaConstrutorParametroNulo() {
        new Cabecalho(null);
    }

    @Test(expected = EntidadeDeLeituraException.class)
    public void testaConstrutorParametroVazio() {
        new Cabecalho(new ArrayList<>());
    }
}