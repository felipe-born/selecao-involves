package br.com.involves.selecao.dominio;

public enum TipoDeParametro {

    PARAMETRO_ARQUIVO("--file=", "cidades.csv");

    private String argumento;
    private String valorPadrao;

    TipoDeParametro(String argumento, String valorPadrao) {

        this.argumento = argumento;
        this.valorPadrao = valorPadrao;
    }

    public String getArgumento() {
        return argumento;
    }

    public String getValorPadrao() {
        return valorPadrao;
    }

    public static TipoDeParametro getTipo(String argumento) {
        for (TipoDeParametro tipo : values())
            if (tipo.argumento.equals(argumento))
                return tipo;
        return null;
    }

}
