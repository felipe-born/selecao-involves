package br.com.involves.selecao.conversor;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;
import br.com.involves.selecao.modelo.EntidadeCabecalho;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;

import java.util.Collection;

public class ConversorConjuntoDadosComPropriedades implements ConversorEntidadeParaEntradaComando<EntidadeComPropriedades, ConjuntoDadosComPropriedade> {

    @Override
    public ConjuntoDadosComPropriedade converter(Collection<EntidadeComPropriedades> entrada) {
        if (entrada == null || entrada.isEmpty())
            return null;

        Collection<String> colunas = entrada.stream()
                .findAny()
                .get()
                .getColunas();

        try {
            EntidadeCabecalho cabecalho = new EntidadeCabecalho(colunas);
            ConjuntoDadosComPropriedade conjuntoDadosComPropriedade =
                    new ConjuntoDadosComPropriedade(cabecalho);
            conjuntoDadosComPropriedade.adiciona(entrada);

            return conjuntoDadosComPropriedade;
        } catch (EntidadeDeLeituraException e) {
            e.printStackTrace();
            return null;
        }
    }
}
