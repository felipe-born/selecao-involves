package br.com.involves.selecao.conversor;

import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.EntradaComando;

import java.util.Collection;

public interface ConversorEntradaComando<E extends EntidadeDeLeitura, S extends EntradaComando> extends Conversor<E, S> {

    @Override
    S converter(Collection<E> entrada);

}
