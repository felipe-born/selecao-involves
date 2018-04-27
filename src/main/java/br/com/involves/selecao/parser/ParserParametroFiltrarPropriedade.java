package br.com.involves.selecao.parser;

import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.excecao.ParametroParserException;

import java.util.List;

import static br.com.involves.selecao.excecao.ConstantesExcecao.COMANDO_INVALIDO;

public class ParserParametroFiltrarPropriedade implements ParametroComandoParser {
    @Override
    public List<String> parse(String comandoParametrizado) {
        if (comandoParametrizado == null)
            throw new NullPointerException("Comando não pode ser nulo");
        if (!verificaComandoComParametro(comandoParametrizado, TipoDeComando.FILTRAR_PROPRIEDADE.getNomeDoComando()))
            throw new ParametroParserException(COMANDO_INVALIDO);
        List<String> listaDeParametros = getListaDeParametros(comandoParametrizado, TipoDeComando.FILTRAR_PROPRIEDADE.getNomeDoComando());
        if (listaDeParametros.size() != 2)
            throw new ParametroParserException("Quantidade de parâmetros é diferente do esperado. Esperado é: propriedade valor. " +
                    "Caso o parâmetro seja nome composto, você pode usar \". Por exemplo: filter name \"são josé\"");
        return listaDeParametros;
    }
}
