package br.com.involves.selecao.parser;

import java.util.List;

public interface ParametroComandoParser {
    List<String> parse(String comando);
}
