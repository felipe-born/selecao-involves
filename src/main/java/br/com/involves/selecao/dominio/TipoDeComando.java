package br.com.involves.selecao.dominio;

import br.com.involves.selecao.modelo.AjudaHandler;
import br.com.involves.selecao.modelo.ComandoHandler;
import br.com.involves.selecao.modelo.ComandoNaoDefinidoHandler;
import br.com.involves.selecao.modelo.ExitHandler;

public enum TipoDeComando {
    CONTAR_TODOS("count *", new ComandoNaoDefinidoHandler()),
    CONTAR_PROPRIEDADES_DISTINTAS("count distinct", new ComandoNaoDefinidoHandler()),
    FILTRAR_PROPRIEDADE("filter", new ComandoNaoDefinidoHandler()),
    SAIR("exit", new ExitHandler()),
    AJUDA("help", new AjudaHandler());

    private String nomeDoComando;
    private ComandoHandler handler;

    TipoDeComando(String nomeDoComando, ComandoHandler handler) {

        this.nomeDoComando = nomeDoComando;
        this.handler = handler;
    }

    public static TipoDeComando getComandoCom(String nome) {
        if(nome == null)
            return AJUDA;
        for (TipoDeComando tipoDeComando : values())
            if (nome.startsWith(tipoDeComando.nomeDoComando))
                return tipoDeComando;
        return AJUDA;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ComandoHandler getHandler() {
        return handler;
    }
}