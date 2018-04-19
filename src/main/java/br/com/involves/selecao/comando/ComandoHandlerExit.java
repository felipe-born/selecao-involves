package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaDeComando;

public class ComandoHandlerExit implements ComandoHandler {

    @Override
    public void exec(String comando, EntradaDeComando entradaDeComando) {
        System.out.println("Saindo do programa!");
        System.exit(0);
    }
}
