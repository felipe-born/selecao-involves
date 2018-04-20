package br.com.involves.selecao.comando;

import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.modelo.EntradaDeComando;

import java.util.stream.Collectors;

public class ComandoHandlerAjuda implements ComandoHandler {
    @Override
    public String exec(String comando, EntradaDeComando entradaDeComando) {
        String textoDeAjuda = TipoDeComando.valuesAsList()
                .stream()
                .map(tipoDeComando -> String.format("%s: %s", tipoDeComando.getNomeDoComando(), tipoDeComando.getDescricaoDoComando()))
                .collect(Collectors.joining("\n\t",
                        "Os comandos disponíveis estão listados abaixo:\n",
                        "\n___________________________"));
        return textoDeAjuda;
    }
}
