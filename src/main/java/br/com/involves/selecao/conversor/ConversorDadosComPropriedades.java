package br.com.involves.selecao.conversor;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import br.com.involves.selecao.modelo.DadosComPropriedade;
import br.com.involves.selecao.modelo.Cabecalho;
import br.com.involves.selecao.modelo.Propriedades;

import java.util.Collection;

public class ConversorDadosComPropriedades implements ConversorEntradaComando<Propriedades, DadosComPropriedade> {

    @Override
    public DadosComPropriedade converter(Collection<Propriedades> entrada) {
        if (entrada == null || entrada.isEmpty())
            return null;

        Collection<String> colunas = entrada.stream()
                .findAny()
                .get()
                .getColunas();

        try {
            Cabecalho cabecalho = new Cabecalho(colunas);
            DadosComPropriedade dadosComPropriedade =
                    new DadosComPropriedade(cabecalho);
            dadosComPropriedade.adiciona(entrada);

            return dadosComPropriedade;
        } catch (EntidadeDeLeituraException e) {
            e.printStackTrace();
            return null;
        }
    }
}
