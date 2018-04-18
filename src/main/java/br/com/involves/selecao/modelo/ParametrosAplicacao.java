package br.com.involves.selecao.modelo;

public class ParametrosAplicacao {
    private final String arquivo;
    private final boolean ignorarErrosDasLinhas;

    public ParametrosAplicacao(String arquivo, boolean ignorarErrosDasLinhas) {
        if (arquivo == null)
            throw new NullPointerException("Arquivo não pode ser nulo!");

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
