package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.EntradaComando;
import br.com.involves.selecao.modelo.RetornoComando;

public class ComandoSaida implements Comando {

    @Override
    public RetornoComando exec(String comando, EntradaComando entradaComando) {
        return new RetornoComando("Saindo do programa!", 0);
    }
}
