package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;

public class ComandoHandlerContarTodos implements ComandoHandler<ConjuntoDadosComPropriedade> {

    @Override
    public String exec(String comando, ConjuntoDadosComPropriedade entradaDeComando) {
        if (entradaDeComando == null)
            return "0";
        Integer totalDeValores = entradaDeComando
                .getTotalDeValores();
        return totalDeValores.toString();
    }
}
