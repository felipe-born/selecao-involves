package br.com.involves.selecao.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConjuntoDadosComPropriedade implements EntradaDeComando {

    private final EntidadeCabecalho cabecalho;
    private List<EntidadeComPropriedades> valores = new ArrayList<>();

    public ConjuntoDadosComPropriedade(EntidadeCabecalho cabecalho) {
        this.cabecalho = cabecalho;
    }

    public void adiciona(Collection<EntidadeComPropriedades> valor) {
        this.valores.addAll(valor);
    }

    public EntidadeCabecalho getCabecalho() {
        return cabecalho;
    }

    public List<EntidadeComPropriedades> getValores() {
        return Collections.unmodifiableList(valores);
    }

    public int getTotalDeValores() {
        return valores.size();
    }
}
