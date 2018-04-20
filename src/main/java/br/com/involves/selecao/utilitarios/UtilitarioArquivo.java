package br.com.involves.selecao.utilitarios;

public class UtilitarioArquivo {

    public static String getExtensao(String arquivo) {
        int indiceTipoDeArquivo = arquivo.lastIndexOf(".");
        return indiceTipoDeArquivo == -1 ? "" : arquivo.substring(indiceTipoDeArquivo + 1, arquivo.length());
    }
}
