package br.com.involves.selecao.validador;

import br.com.involves.selecao.excecao.ValidacaoException;

public interface Validador<T> {

    public void valida(T elemento) throws ValidacaoException;
}
