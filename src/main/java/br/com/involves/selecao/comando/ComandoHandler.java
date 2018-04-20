package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaDeComando;

public interface ComandoHandler<T extends EntradaDeComando> {
    String exec(String comando, T entradaDeComando);
}
