package br.com.involves.selecao.modelo;

import java.io.InputStream;

public class ArquivoDeLeitura {
    private final String extensao;
    private final String caminhoArquivo;
    private final InputStream inputStream;

    public ArquivoDeLeitura(String arquivo, InputStream inputStream) {
        if (arquivo == null)
            throw new NullPointerException("Arquivo não pode ser nulo");

        int indiceTipoDeArquivo = arquivo.lastIndexOf(".");
        this.extensao = indiceTipoDeArquivo == -1 ? "" : arquivo.substring(indiceTipoDeArquivo + 1, arquivo.length());
        this.caminhoArquivo = arquivo;
        this.inputStream = inputStream;
    }

    public String getExtensao() {
        return extensao;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
