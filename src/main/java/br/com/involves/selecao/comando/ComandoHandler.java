package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaDeComando;
import br.com.involves.selecao.modelo.RetornoComando;

public interface ComandoHandler<T extends EntradaDeComando> {
    RetornoComando exec(String comando, T entradaDeComando);
}
