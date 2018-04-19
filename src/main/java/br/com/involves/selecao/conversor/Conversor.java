package br.com.involves.selecao.conversor;

import java.util.Collection;

public interface Conversor<E, S> {

    S converter(Collection<E> entrada);
}
