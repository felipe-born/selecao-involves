package br.com.involves.selecao.flyweight;

import br.com.involves.selecao.comando.*;
import br.com.involves.selecao.parser.ParserParametroContarDistintos;
import br.com.involves.selecao.parser.ParserParametroFiltrarPropriedade;

import java.util.HashMap;
import java.util.Map;

public class ControleRemoto implements Flyweight<Comando> {
    public static ControleRemoto instancia;

    /**
     * Singleton
     */
    public static ControleRemoto getInstancia() {
        if (instancia == null)
            instancia = new ControleRemoto();
        return instancia;
    }


    private Map<Class<? extends Comando>, Comando> mapClazzToHandler = new HashMap<>();

    private ControleRemoto() {
        adiciona(new ComandoAjuda());
        adiciona(new ComandoContarTodos());
        adiciona(new ComandoContarDistintos(new ParserParametroContarDistintos()));
        adiciona(new ComandoSaida());
        adiciona(new ComandoFiltragem(new ParserParametroFiltrarPropriedade()));
    }

    private void adiciona(Comando handler) {
        mapClazzToHandler.put(handler.getClass(), handler);
    }

    @Override
    public Comando getInstance(Class<? extends Comando> clazz) {
        return mapClazzToHandler.get(clazz);
    }
}
