package br.com.involves.selecao.modelo;

public class ParametrosAplicacao {
    private final String arquivo;

    public ParametrosAplicacao(String arquivo) {
        if (arquivo == null)
            throw new NullPointerException("Arquivo não pode ser nulo!");

        this.arquivo = arquivo;
    }

    public String getArquivo() {
        return arquivo;
    }


    @Override
    public String toString() {
        return "ParametrosAplicacao{" + "arquivo='" + arquivo + '}';
    }
}
