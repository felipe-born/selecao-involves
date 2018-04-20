package br.com.involves.selecao.flyweight;

import br.com.involves.selecao.comando.*;
import br.com.involves.selecao.parser.ParserParametroContarDistintos;
import br.com.involves.selecao.parser.ParserParametroFiltrarPropriedade;

import java.util.HashMap;
import java.util.Map;

public class ControleRemoto implements Flyweight<ComandoHandler> {
    public static ControleRemoto instancia;

    /**
     * Singleton
     */
    public static ControleRemoto getInstancia() {
        if (instancia == null)
            instancia = new ControleRemoto();
        return instancia;
    }


    private Map<Class<? extends ComandoHandler>, ComandoHandler> mapClazzToHandler = new HashMap<>();

    private ControleRemoto() {
        adiciona(new ComandoHandlerAjuda());
        adiciona(new ComandoHandlerContarTodos());
        adiciona(new ComandoHandlerContarDistintos(new ParserParametroContarDistintos()));
        adiciona(new ComandoHandlerExit());
        adiciona(new ComandoHandlerFiltrarPropriedade(new ParserParametroFiltrarPropriedade()));
    }

    private void adiciona(ComandoHandler handler) {
        mapClazzToHandler.put(handler.getClass(), handler);
    }

    @Override
    public ComandoHandler getInstance(Class<? extends ComandoHandler> clazz) {
        return mapClazzToHandler.get(clazz);
    }
}
