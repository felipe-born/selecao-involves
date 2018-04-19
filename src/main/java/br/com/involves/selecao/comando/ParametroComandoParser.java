package br.com.involves.selecao.comando;

import java.util.List;

public interface ParametroComandoParser {
    List<String> parse(String comando);
}
