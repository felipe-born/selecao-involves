package br.com.involves.selecao.parser;

import java.util.Arrays;
import java.util.List;

public interface ParametroComandoParser {

    default List<String> getListaDeParametros(String comandoParametrizado, String comando) {
        int tamanhoDoComando = comando.split(" ").length;

        String[] palavrasDoComandoParametrizado = comandoParametrizado.split(" ");
        String[] parametrosDoComando = Arrays
                .copyOfRange(palavrasDoComandoParametrizado, tamanhoDoComando, palavrasDoComandoParametrizado.length);
        return Arrays.asList(parametrosDoComando);
    }

    default boolean verificaComandoComParametro(String parametroEnviado, String comando) {
        boolean startsWith = parametroEnviado.startsWith(comando);
        return startsWith;
    }

    List<String> parse(String comando);
}
