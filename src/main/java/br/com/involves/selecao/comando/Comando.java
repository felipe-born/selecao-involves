package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaComando;
import br.com.involves.selecao.modelo.RetornoComando;

public interface Comando<T extends EntradaComando> {
    RetornoComando exec(String comando, T entradaDeComando);
}
