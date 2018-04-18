package br.com.involves.selecao.modelo;

import com.sun.istack.internal.NotNull;

public class ParametrosAplicacao {
    private final String arquivo;
    private final boolean ignorarErrosDasLinhas;

    public ParametrosAplicacao(@NotNull String arquivo, boolean ignorarErrosDasLinhas) {

        this.arquivo = arquivo;
        this.ignorarErrosDasLinhas = ignorarErrosDasLinhas;
    }

    public String getArquivo() {
        return arquivo;
    }

    public boolean isIgnorarErrosDasLinhas() {
        return ignorarErrosDasLinhas;
    }

    @Override
    public String toString() {
        return "ParametrosAplicacao{" +
                "arquivo='" + arquivo + '\'' +
                ", ignorarErrosDasLinhas=" + ignorarErrosDasLinhas +
                '}';
    }
}
