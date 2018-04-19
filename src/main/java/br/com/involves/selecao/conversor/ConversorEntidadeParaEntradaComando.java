package br.com.involves.selecao.conversor;

import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.EntradaDeComando;

import java.util.Collection;

public interface ConversorEntidadeParaEntradaComando<E extends EntidadeDeLeitura, S extends EntradaDeComando> extends Conversor<E, S> {

    @Override
    S converter(Collection<E> entrada);

}
