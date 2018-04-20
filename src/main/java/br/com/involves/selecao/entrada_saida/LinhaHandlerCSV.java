package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.builder.EntidadeComPropriedadesBuilder;
import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import br.com.involves.selecao.modelo.EntidadeCabecalho;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinhaHandlerCSV implements LinhaHandler {
    private List<String> cabecalhoCSV = new ArrayList<>();

    @Override
    public EntidadeDeLeitura lidarCom(String conteudo) throws EntidadeDeLeituraException {
        if (cabecalhoCSV.isEmpty()) {
            cabecalhoCSV = leiaCSV(conteudo);
            return new EntidadeCabecalho(cabecalhoCSV);
        }
        List<String> valores = leiaCSV(conteudo);
        if (valores.size() != cabecalhoCSV.size())
            throw new EntidadeDeLeituraException("Conteúdo com quantidade de parâmetros divergente: " + conteudo);

        return new EntidadeComPropriedadesBuilder()
                .comPropriedades(cabecalhoCSV)
                .comValores(valores)
                .build();
    }

    private List<String> leiaCSV(String conteudo) {
        String[] split = conteudo.split(",");
        return Arrays.asList(split);
    }
}
