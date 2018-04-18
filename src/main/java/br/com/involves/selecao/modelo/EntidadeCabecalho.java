package br.com.involves.selecao.modelo;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EntidadeCabecalho implements EntidadeDeLeitura {
    private List<String> cabecalhoCSV;

    public EntidadeCabecalho(List<String> cabecalhoCSV) throws EntidadeDeLeituraException {
        if (cabecalhoCSV == null)
            throw new EntidadeDeLeituraException(new NullPointerException("Cabeçalho CSV não pode ser nulo!"));
        if (cabecalhoCSV.isEmpty())
            throw new EntidadeDeLeituraException("Cabeçalho CSV não pode estar vazio!");

        this.cabecalhoCSV = Collections.unmodifiableList(cabecalhoCSV);
    }

    @Override
    public String toString() {
        return cabecalhoCSV
                .stream()
                .collect(Collectors.joining(" | "));
    }
}
