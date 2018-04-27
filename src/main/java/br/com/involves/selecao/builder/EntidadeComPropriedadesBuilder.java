package br.com.involves.selecao.builder;

import br.com.involves.selecao.modelo.Propriedades;
import javafx.util.Builder;

import java.util.Arrays;
import java.util.List;

public class EntidadeComPropriedadesBuilder implements Builder<Propriedades> {
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
    public Propriedades build() {
        Propriedades propriedades = new Propriedades();
        for (int indiceDaPropriedade = 0; indiceDaPropriedade < cabecalho.size(); indiceDaPropriedade++) {
            String propriedade = cabecalho.get(indiceDaPropriedade);
            String valor = valores.get(indiceDaPropriedade);
            propriedades.addPropriedade(propriedade, valor);
        }
        return propriedades;
    }
}
