package br.com.involves.selecao.validador;

import br.com.involves.selecao.excecao.ValidacaoException;
import br.com.involves.selecao.modelo.ParametrosAplicacao;

public class ValidadorDeParametrosAplicacao implements Validador<ParametrosAplicacao> {

    @Override
    public void valida(ParametrosAplicacao elemento) throws ValidacaoException {
        if (elemento.getArquivo() == null)
            throw new ValidacaoException(new NullPointerException("Parâmetro arquivo não pode ser nulo!"));
        if (elemento.getArquivo().isEmpty())
            throw new ValidacaoException("Parâmetro arquivo não pode ser vazio!");
    }
}
