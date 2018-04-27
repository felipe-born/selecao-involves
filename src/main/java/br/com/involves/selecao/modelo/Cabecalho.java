package br.com.involves.selecao.modelo;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;

import java.util.*;
import java.util.stream.Collectors;

public class Cabecalho implements EntidadeDeLeitura {
    private Collection<String> cabecalhoCSV;

    public Cabecalho(Collection<String> cabecalhoCSV) throws EntidadeDeLeituraException {
        if (cabecalhoCSV == null)
            throw new EntidadeDeLeituraException(new NullPointerException("Cabeçalho CSV não pode ser nulo!"));
        if (cabecalhoCSV.isEmpty())
            throw new EntidadeDeLeituraException("Cabeçalho CSV não pode estar vazio!");

        this.cabecalhoCSV = Collections.unmodifiableCollection(cabecalhoCSV);
    }

    public List<String> getCabecalhoAsList() {
        return new ArrayList<>(cabecalhoCSV);
    }

    @Override
    public String toString() {
        return cabecalhoCSV
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.joining(" | "));
    }

    public boolean contem(String valor) {
        return cabecalhoCSV
                .stream()
                .anyMatch(propriedade -> propriedade.equals(valor));
    }
}
