package br.com.involves.selecao.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DadosComPropriedade implements EntradaComando {

    private final Cabecalho cabecalho;
    private List<Propriedades> valores = new ArrayList<>();

    public DadosComPropriedade(Cabecalho cabecalho) {
        this.cabecalho = cabecalho;
    }

    public void adiciona(Collection<Propriedades> valor) {
        this.valores.addAll(valor);
    }

    public void adiciona(Propriedades propriedades) {
        valores.add(propriedades);
    }

    public Cabecalho getCabecalho() {
        return cabecalho;
    }

    public List<Propriedades> getValores() {
        return Collections.unmodifiableList(valores);
    }

    public int getTotalDeValores() {
        return valores.size();
    }

    public String getCabecalhoAsString() {
        if (getCabecalho() == null)
            return "";
        return getCabecalho().toString();
    }
}
