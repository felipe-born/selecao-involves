package br.com.involves.selecao.controlador;

import br.com.involves.selecao.dominio.TipoDeParametro;
import br.com.involves.selecao.modelo.ParametrosAplicacao;

import java.util.Arrays;
import java.util.List;

public class ControladorParametros implements Controlador {
    private final ControladorAlertas controladorAlertas;
    private List<String> parametros;

    public ControladorParametros(String[] parametros, ControladorAlertas controladorAlertas) {

        this.parametros = Arrays.asList(parametros);
        this.controladorAlertas = controladorAlertas;
    }

    public ParametrosAplicacao controle() {
        lidaComParametrosInexistentes();
        return geraParametrosAplicacao();
    }

    private void lidaComParametrosInexistentes() {
        parametros
                .stream()
                .map(argumento -> argumento.substring(0, argumento.indexOf("=") + 1))
                .filter(argumento -> TipoDeParametro.getTipo(argumento) == null)
                .forEach(argumento -> controladorAlertas.criaNovoAlerta(argumento));
    }

    private ParametrosAplicacao geraParametrosAplicacao() {
        String arquivo = getValorDoParametro(TipoDeParametro.PARAMETRO_ARQUIVO);

        return new ParametrosAplicacao(arquivo);
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


