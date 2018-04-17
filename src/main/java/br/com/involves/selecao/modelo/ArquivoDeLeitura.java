package br.com.involves.selecao.modelo;

public class ArquivoDeLeitura {
    private final String extensao;
    private final String caminhoArquivo;

    public ArquivoDeLeitura(String arquivo) {
        int indiceTipoDeArquivo = arquivo.lastIndexOf(".");
        this.extensao = indiceTipoDeArquivo == -1 ? "" : arquivo.substring(indiceTipoDeArquivo+1, arquivo.length());
        this.caminhoArquivo = arquivo;
    }

    public String getExtensao() {
        return extensao;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
