package br.com.involves.selecao.comando;

import br.com.involves.selecao.modelo.DadosComPropriedade;
import br.com.involves.selecao.modelo.RetornoComando;
import br.com.involves.selecao.parser.ParametroComandoParser;

import java.util.List;
import java.util.stream.Collectors;

public class ComandoFiltragem implements Comando<DadosComPropriedade> {
    private final ParametroComandoParser parser;

    public ComandoFiltragem(ParametroComandoParser parser) {

        this.parser = parser;
    }

    @Override
    public RetornoComando exec(String comando, DadosComPropriedade entradaDeComando) {
        List<String> parametros;
        try {
            parametros = parser.parse(comando);
        } catch (Exception e) {
            return new RetornoComando(e);
        }
        
        String propriedade = parametros.get(0);
        String valor = parametros.get(1);

        String cabecalho = entradaDeComando.getCabecalhoAsString();

        String listagemDeValores = entradaDeComando.getValores()
                .stream()
                .filter(entidade -> entidade.possuiPropriedadeComValor(propriedade, valor))
                .map(entidade -> entidade.toString())
                .collect(Collectors.joining("\n", cabecalho + "\n", ""));
        return new RetornoComando(listagemDeValores);
    }
}
