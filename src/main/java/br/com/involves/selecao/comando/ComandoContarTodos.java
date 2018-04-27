package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.DadosComPropriedade;
import br.com.involves.selecao.modelo.RetornoComando;

public class ComandoContarTodos implements Comando<DadosComPropriedade> {

    @Override
    public RetornoComando exec(String comando, DadosComPropriedade entradaDeComando) {
        if (entradaDeComando == null)
            return new RetornoComando("0");
        Integer totalDeValores = entradaDeComando
                .getTotalDeValores();
        return new RetornoComando(totalDeValores.toString());
    }
}
