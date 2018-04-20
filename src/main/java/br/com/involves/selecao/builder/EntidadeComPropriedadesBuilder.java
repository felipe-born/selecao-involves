package br.com.involves.selecao.builder;

import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import javafx.util.Builder;

import java.util.Arrays;
import java.util.List;

public class EntidadeComPropriedadesBuilder implements Builder<EntidadeComPropriedades> {
    private List<String> cabecalho;
    private List<String> valores;

    public EntidadeComPropriedadesBuilder comPropriedades(String... cabecalho) {
        return comPropriedades(Arrays.asList(cabecalho));
    }

    public EntidadeComPropriedadesBuilder comPropriedades(List<String> cabecalho) {
        this.cabecalho = cabecalho;
        return this;
    }

    public EntidadeComPropriedadesBuilder comValores(String ... valores) {
        return comValores(Arrays.asList(valores));
    }

    public EntidadeComPropriedadesBuilder comValores(List<String> valores) {
        this.valores = valores;
        return this;
    }

    @Override
    public EntidadeComPropriedades build() {
        EntidadeComPropriedades entidadeComPropriedades = new EntidadeComPropriedades();
        for (int indiceDaPropriedade = 0; indiceDaPropriedade < cabecalho.size(); indiceDaPropriedade++) {
            String propriedade = cabecalho.get(indiceDaPropriedade);
            String valor = valores.get(indiceDaPropriedade);
            entidadeComPropriedades.addPropriedade(propriedade, valor);
        }
        return entidadeComPropriedades;
    }
}
