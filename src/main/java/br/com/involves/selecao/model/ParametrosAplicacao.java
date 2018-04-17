package br.com.involves.selecao.model;

public class ParametrosAplicacao {
    private final String arquivo;
    private final boolean ignorarErrosDasLinhas;

    public ParametrosAplicacao(String arquivo, boolean ignorarErrosDasLinhas) {

        this.arquivo = arquivo;
        this.ignorarErrosDasLinhas = ignorarErrosDasLinhas;
    }

    @Override
    public String toString() {
        return "ParametrosAplicacao{" +
                "arquivo='" + arquivo + '\'' +
                ", ignorarErrosDasLinhas=" + ignorarErrosDasLinhas +
                '}';
    }

    public String getArquivo() {
        return arquivo;
    }

    public boolean isIgnorarErrosDasLinhas() {
        return ignorarErrosDasLinhas;
    }
}
