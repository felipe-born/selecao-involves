package br.com.involves.selecao.controlador;

import br.com.involves.selecao.dominio.TipoDeParametro;
import br.com.involves.selecao.model.ParametrosAplicacao;

import java.util.Arrays;
import java.util.List;

public class ControladorDeParametrosAplicacao implements Controlador<ParametrosAplicacao> {
    private List<String> parametros;

    public ControladorDeParametrosAplicacao(String[] parametros) {

        this.parametros = Arrays.asList(parametros);
    }

    public ParametrosAplicacao controle() {
        lidaComParametrosInexistentes();
        return geraParametrosAplicacao();
    }

    private void lidaComParametrosInexistentes() {
        parametros
                .stream()
                .map(argumento -> argumento.substring(0, argumento.indexOf("=")+1))
                .filter(argumento -> TipoDeParametro.getTipo(argumento) == null)
                .forEach(argumento -> System.out.println("Argumento inexistente: " + argumento));
    }

    private ParametrosAplicacao geraParametrosAplicacao() {
        String arquivo = getValorDoParametro(TipoDeParametro.PARAMETRO_ARQUIVO);
        String valorDoParametro = getValorDoParametro(TipoDeParametro.PARAMETRO_IGNORAR_ERROS);
        boolean ignorarErro = Boolean.parseBoolean(valorDoParametro);

        return new ParametrosAplicacao(arquivo, ignorarErro);
    }

    private String getValorDoParametro(TipoDeParametro tipoDeParametro) {
        return parametros
                .stream()
                .filter(parametro -> parametro.startsWith(tipoDeParametro.getArgumento()))
                .map(parametro -> parametro.substring(tipoDeParametro.getArgumento().length()))
                .findAny()
                .orElse(tipoDeParametro.getValorPadrao());
    }

}


