package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaDeComando;

public class ComandoNaoDefinidoHandler implements ComandoHandler {

    @Override
    public void exec(String comando, EntradaDeComando entradaDeComando) {
        System.out.println("Comando " + comando + " Ainda não foi implementado!");
    }
}
