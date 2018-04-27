package br.com.involves.selecao.dominio;

import br.com.involves.selecao.comando.*;

import java.util.Arrays;
import java.util.List;

import static br.com.involves.selecao.comando.ConstantesComando.*;

public enum TipoDeComando {
    CONTAR_TODOS(CM_CONTAR_TODOS, DS_CONTAR_TODOS, ComandoContarTodos.class),
    CONTAR_PROPRIEDADES_DISTINTAS(CM_PROPRIEDADES_DISTINTAS, DS_PROPRIEDADES_DISTINTAS, ComandoContarDistintos.class),
    FILTRAR_PROPRIEDADE(CM_FILTRAR_PROPRIEDADES, DS_FILTRAR_PROPRIEDADES, ComandoFiltragem.class),
    SAIR(CM_SAIR, DS_SAIR, ComandoSaida.class),
    AJUDA(CM_AJUDA, DS_AJUDA, ComandoAjuda.class);

    private String nomeDoComando;
    private String descricaoDoComando;
    private Class<? extends Comando> handler;

    TipoDeComando(String nomeDoComando, String descricaoDoComando, Class<? extends Comando> handler) {

        this.nomeDoComando = nomeDoComando;
        this.descricaoDoComando = descricaoDoComando;
        this.handler = handler;
    }

    public static TipoDeComando getComandoCom(String nome) {
        if (nome == null)
            return AJUDA;
        for (TipoDeComando tipoDeComando : values())
            if (nome.startsWith(tipoDeComando.nomeDoComando))
                return tipoDeComando;
        return AJUDA;
    }

    @Override
    public String toString() {
        return getNomeDoComando();
    }

    public String getNomeDoComando() {
        return nomeDoComando;
    }

    public String getDescricaoDoComando() {
        return descricaoDoComando;
    }

    public Class<? extends Comando> getHandlerClazz() {
        return handler;
    }

    public static List<TipoDeComando> valuesAsList() {
        return Arrays.asList(values());
    }
}