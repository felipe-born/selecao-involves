package br.com.involves.selecao.modelo;

import java.util.Objects;

public class RetornoComando implements Saida {

    private String mensagem;
    private int sinalTerminate = -1;
    private Exception excecao;

    public RetornoComando(String mensagem) {
        this.mensagem = mensagem;
    }

    public RetornoComando(Exception excecao) {
        this.mensagem = excecao.getMessage();
        this.excecao = excecao;
    }

    public RetornoComando(String mensagem, int sinalTerminate) {
        this.mensagem = mensagem;
        this.sinalTerminate = sinalTerminate;
    }

    public boolean indicaFimExecucao() {
        return sinalTerminate >= 0;
    }

    public boolean retornoComFalhas() {
        return excecao != null;
    }

    @Override
    public String toString() {
        return this.mensagem;
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
