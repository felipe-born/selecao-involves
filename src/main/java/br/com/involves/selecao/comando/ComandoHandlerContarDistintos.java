package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;
import br.com.involves.selecao.modelo.RetornoComando;
import br.com.involves.selecao.parser.ParametroComandoParser;

import java.util.List;
import java.util.stream.Collectors;

public class ComandoHandlerContarDistintos implements ComandoHandler<ConjuntoDadosComPropriedade> {

    private final ParametroComandoParser comandoParser;

    public ComandoHandlerContarDistintos(ParametroComandoParser comandoParser) {

        this.comandoParser = comandoParser;
    }

    @Override
    public RetornoComando exec(String comando, ConjuntoDadosComPropriedade entradaDeComando) {
        String valorParametro = this.comandoParser
                .parse(comando)
                .get(0);
        List<String> valoresDistintos = entradaDeComando.getValores()
                .stream()
                .map(entidade -> entidade.getValor(valorParametro))
                .filter(valor -> valor != null && !valor.isEmpty())
                .distinct()
                .collect(Collectors.toList());
        Integer quantidadeDeValoresDistintos = valoresDistintos.size();
        return new RetornoComando(quantidadeDeValoresDistintos.toString());
    }
}