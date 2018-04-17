package br.com.involves.selecao.modelo;

public class EntidadeComPropriedades implements EntidadeDeLeitura {
    private final String string;

    public EntidadeComPropriedades(String conteudo) {
        this.string = conteudo;
    }

    @Override
    public String toString() {
        return string;
    }
}
