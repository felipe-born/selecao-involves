package br.com.involves.selecao.dominio;

import br.com.involves.selecao.entrada_saida.LinhaHandler;
import br.com.involves.selecao.entrada_saida.LinhaHandlerCSV;

public enum TipoDeArquivo {
    ARQUIVO_CSV("csv", new LinhaHandlerCSV());

    private final String extensao;
    private final LinhaHandler linhaHandler;

    TipoDeArquivo(String extensao, LinhaHandler linhaHandler) {

        this.extensao = extensao;
        this.linhaHandler = linhaHandler;
    }

    public LinhaHandler getLinhaHandler() {
        return linhaHandler;
    }

    public static TipoDeArquivo getTipoDeArquivo(String extensao) {
        for (TipoDeArquivo tipoDeArquivo : values())
            if (tipoDeArquivo.extensao.equals(extensao))
                return tipoDeArquivo;
        return null;
    }
}
