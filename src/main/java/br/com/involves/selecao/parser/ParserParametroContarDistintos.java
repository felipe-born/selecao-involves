package br.com.involves.selecao.parser;

import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.excecao.ParametroParserException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserParametroContarDistintos implements ParametroComandoParser {

    @Override
    public List<String> parse(String comandoParametrizado) {
        if (comandoParametrizado == null)
            throw new NullPointerException("Comando não pode ser nulo");
        if (!verificaComandoComParametro(comandoParametrizado, TipoDeComando.CONTAR_PROPRIEDADES_DISTINTAS.getNomeDoComando()))
            throw new ParametroParserException();
        String parametrosUnidos = getListaDeParametros(comandoParametrizado,
                TipoDeComando.CONTAR_PROPRIEDADES_DISTINTAS.getNomeDoComando())
                .stream()
                .collect(Collectors.joining(" "));
        return Arrays.asList(parametrosUnidos);
    }
}
