package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;
import br.com.involves.selecao.modelo.RetornoComando;

public class ComandoHandlerContarTodos implements ComandoHandler<ConjuntoDadosComPropriedade> {

    @Override
    public RetornoComando exec(String comando, ConjuntoDadosComPropriedade entradaDeComando) {
        if (entradaDeComando == null)
            return new RetornoComando("0");
        Integer totalDeValores = entradaDeComando
                .getTotalDeValores();
        return new RetornoComando(totalDeValores.toString());
    }
}
