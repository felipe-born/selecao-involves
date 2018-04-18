package br.com.involves.selecao.modelo;

import com.sun.istack.internal.NotNull;

public class ArquivoDeLeitura {
    private final String extensao;
    private final String caminhoArquivo;

    public ArquivoDeLeitura(@NotNull String arquivo) {
        int indiceTipoDeArquivo = arquivo.lastIndexOf(".");
        this.extensao = indiceTipoDeArquivo == -1 ? "" : arquivo.substring(indiceTipoDeArquivo + 1, arquivo.length());
        this.caminhoArquivo = arquivo;
    }

    public String getExtensao() {
        return extensao;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
