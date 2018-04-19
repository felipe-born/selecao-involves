package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;

public class ComandoHandlerContarTodos implements ComandoHandler<ConjuntoDadosComPropriedade> {

    @Override
    public void exec(String comando, ConjuntoDadosComPropriedade entradaDeComando) {
        int totalDeValores = entradaDeComando
                .getTotalDeValores();
        System.out.println(totalDeValores);
    }
}
