package br.com.involves.selecao.modelo;

import java.util.Objects;

public class RetornoComando implements Saida {

    private String mensagem;
    private int sinalTerminate = -1;

    public RetornoComando(String mensagem) {
        this.mensagem = mensagem;
    }

    public RetornoComando(String mensagem, int sinalTerminate) {
        this.mensagem = mensagem;
        this.sinalTerminate = sinalTerminate;
    }

    @Override
    public String toString() {
        return this.mensagem;
    }

    public boolean indicaFimExecucao() {
        return sinalTerminate >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetornoComando that = (RetornoComando) o;
        return Objects.equals(mensagem, that.mensagem);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mensagem);
    }
}
