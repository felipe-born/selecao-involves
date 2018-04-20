package br.com.involves.selecao.modelo;

import br.com.involves.selecao.utilitarios.UtilitarioArquivo;

import java.io.InputStream;

public class ArquivoDeLeitura {
    private final String extensao;
    private final String caminhoArquivo;
    private final InputStream inputStream;

    public ArquivoDeLeitura(String arquivo, InputStream inputStream) {
        if (arquivo == null)
            throw new NullPointerException("Arquivo não pode ser nulo");

        this.extensao = UtilitarioArquivo.getExtensao(arquivo);
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
