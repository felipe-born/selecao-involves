package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.ConjuntoDadosComPropriedade;

import java.util.List;
import java.util.stream.Collectors;

public class ComandoHandlerContarDistintos implements ComandoHandler<ConjuntoDadosComPropriedade> {

    private final ParametroComandoParser comandoParser;

    public ComandoHandlerContarDistintos(ParametroComandoParser comandoParser) {

        this.comandoParser = comandoParser;
    }

    @Override
    public void exec(String comando, ConjuntoDadosComPropriedade entradaDeComando) {
        String valorParametro = this.comandoParser
                .parse(comando)
                .get(0);
        List<String> valoresDistintos = entradaDeComando.getValores()
                .stream()
                .map(entidade -> entidade.getValor(valorParametro))
                .distinct()
                .collect(Collectors.toList());
        int quantidadeDeValoresDistintos = valoresDistintos.size();
        System.out.println(quantidadeDeValoresDistintos);
    }
}