package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaDeComando;

public interface ComandoHandler<T extends EntradaDeComando> {
    void exec(String comando, T entradaDeComando);
}
