package br.com.involves.selecao.modelo;

import java.util.*;
import java.util.stream.Collectors;

public class EntidadeComPropriedades implements EntidadeDeLeitura {

    private Map<String, String> propriedades = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public EntidadeComPropriedades() {
    }

    public void addPropriedade(String propriedade, String valor) {
        propriedades.put(propriedade, valor);
    }

    public Collection<String> getColunas() {
        return Collections.unmodifiableSet(propriedades.keySet());
    }


    public String getValor(String coluna) {
        return propriedades
                .get(coluna);
    }

    public boolean possuiPropriedadeComValor(String propriedade, String valor) {
        if (propriedade == null || valor == null)
            return false;
        String valorDaPropriedade = propriedades.get(propriedade);
        return valorDaPropriedade != null && valorDaPropriedade.equalsIgnoreCase(valor);
    }

    @Override
    public String toString() {
        return propriedades.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(entry -> entry.getValue())
                .collect(Collectors.joining("|"));
    }
}
