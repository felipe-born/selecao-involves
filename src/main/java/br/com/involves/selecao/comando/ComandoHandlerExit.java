package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaDeComando;
import br.com.involves.selecao.modelo.RetornoComando;

public class ComandoHandlerExit implements ComandoHandler {

    @Override
    public RetornoComando exec(String comando, EntradaDeComando entradaDeComando) {
        return new RetornoComando("Saindo do programa!", 0);
    }
}
