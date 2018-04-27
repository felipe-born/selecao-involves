package br.com.involves.selecao.comando;

import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.modelo.EntradaComando;
import br.com.involves.selecao.modelo.RetornoComando;

import java.util.stream.Collectors;

public class ComandoAjuda implements Comando {
    @Override
    public RetornoComando exec(String comando, EntradaComando entradaComando) {
        String textoDeAjuda = TipoDeComando.valuesAsList()
                .stream()
                .map(tipoDeComando -> String.format("%s: %s", tipoDeComando.getNomeDoComando(), tipoDeComando.getDescricaoDoComando()))
                .collect(Collectors.joining("\n\t",
                        "Os comandos disponíveis estão listados abaixo:\n",
                        "\n___________________________"));
        return new RetornoComando(textoDeAjuda);
    }
}
