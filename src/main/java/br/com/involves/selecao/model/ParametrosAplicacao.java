package br.com.involves.selecao.model;

public class ParametrosAplicacao {
    private String arquivo;
    private boolean ignorarErrosDasLinhas;

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
}
