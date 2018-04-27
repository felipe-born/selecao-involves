package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.modelo.RetornoComando;

public class TesteSaidaIU implements SaidaIU<RetornoComando> {
    private String resultado;

    @Override
    public void solicitaComando() {

    }

    @Override
    public void imprime(RetornoComando retornoComando) {
        this.resultado = retornoComando.toString();
    }

    @Override
    public void boasVindas() {

    }

    public boolean estaComResultado(String resultado) {
        if (this.resultado == null)
            return false;
        return this.resultado.equalsIgnoreCase(resultado);
    }
}
