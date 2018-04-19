package br.com.involves.selecao.dominio;

import br.com.involves.selecao.comando.*;

import java.util.Arrays;
import java.util.List;

public enum TipoDeComando {
    CONTAR_TODOS("count *", "Contagem total de registros importados (sem incluir o cabeçalho)", new ComandoHandlerContarTodos()),
    CONTAR_PROPRIEDADES_DISTINTAS("count distinct", "Total de valores distintos da propriedade enviada", new ComandoHandlerContarDistintos(new ParserParametroContarDistintos())),
    FILTRAR_PROPRIEDADE("filter", "Linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor especificado", new ComandoNaoDefinidoHandler()),
    SAIR("exit", "Finaliza a execução do programa", new ComandoHandlerExit()),
    AJUDA("help", "Mostra os comandos disponíveis", new ComandoHandlerAjuda());

    private String nomeDoComando;
    private String descricaoDoComando;
    private ComandoHandler handler;

    TipoDeComando(String nomeDoComando, String descricaoDoComando, ComandoHandler handler) {

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
        return super.toString();
    }

    public String getNomeDoComando() {
        return nomeDoComando;
    }

    public String getDescricaoDoComando() {
        return descricaoDoComando;
    }

    public ComandoHandler getHandler() {
        return handler;
    }

    public static List<TipoDeComando> valuesAsList() {
        return Arrays.asList(values());
    }
}