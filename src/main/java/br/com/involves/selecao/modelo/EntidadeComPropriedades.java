package br.com.involves.selecao.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EntidadeComPropriedades implements EntidadeDeLeitura {

    private Map<String, String> propriedades = new HashMap<>();

    public EntidadeComPropriedades() {
    }

    public void addPropriedade(String propriedade, String valor) {
        propriedades.put(propriedade, valor);
    }

    @Override
    public String toString() {
        return propriedades.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.joining("|"));
    }
}
