package br.com.involves.selecao.parser;

import br.com.involves.selecao.dominio.TipoDeComando;

import java.util.Arrays;
import java.util.List;

public class ParserParametroFiltrarPropriedade implements ParametroComandoParser {
    @Override
    public List<String> parse(String comandoParametrizado) {
        String[] palavrasDoComandoParametrizado = comandoParametrizado.split(" ");
        String[] palavrasDoComando = TipoDeComando.FILTRAR_PROPRIEDADE
                .getNomeDoComando()
                .split(" ");
        String[] parametrosDoComando = Arrays
                .copyOfRange(palavrasDoComandoParametrizado, palavrasDoComando.length, palavrasDoComandoParametrizado.length);
        return Arrays.asList(parametrosDoComando);
    }
}
