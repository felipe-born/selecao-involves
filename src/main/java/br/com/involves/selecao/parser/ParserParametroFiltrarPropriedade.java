package br.com.involves.selecao.parser;

import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.excecao.ParametroParserException;

import java.util.List;

public class ParserParametroFiltrarPropriedade implements ParametroComandoParser {
    @Override
    public List<String> parse(String comandoParametrizado) {
        if (comandoParametrizado == null)
            throw new NullPointerException("Comando não pode ser nulo");
        if (!verificaComandoComParametro(comandoParametrizado, TipoDeComando.FILTRAR_PROPRIEDADE.getNomeDoComando()))
            throw new ParametroParserException();
        List<String> listaDeParametros = getListaDeParametros(comandoParametrizado, TipoDeComando.FILTRAR_PROPRIEDADE.getNomeDoComando());
        if (listaDeParametros.size() != 2)
            throw new ParametroParserException();
        return listaDeParametros;
    }
}
