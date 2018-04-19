package br.com.involves.selecao.parser;

import br.com.involves.selecao.dominio.TipoDeComando;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserParametroContarDistintos implements ParametroComandoParser {

    @Override
    public List<String> parse(String comandoParametrizado) {
        String[] palavrasDoComandoParametrizado = comandoParametrizado.split(" ");
        String[] palavrasDoComando = TipoDeComando.CONTAR_PROPRIEDADES_DISTINTAS
                .getNomeDoComando()
                .split(" ");
        String[] parametrosDoComando = Arrays
                .copyOfRange(palavrasDoComandoParametrizado, palavrasDoComando.length, palavrasDoComandoParametrizado.length);
        String parametrosUnidos = Arrays.asList(parametrosDoComando).stream().collect(Collectors.joining(" "));
        return Arrays.asList(parametrosUnidos);
    }
}
