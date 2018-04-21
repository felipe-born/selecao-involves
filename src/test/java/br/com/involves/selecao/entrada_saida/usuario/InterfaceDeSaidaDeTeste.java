package br.com.involves.selecao.entrada_saida.usuario;

public class InterfaceDeSaidaDeTeste implements InterfaceDeSaida {
    private String resultado;

    @Override
    public void solicitaComando() {

    }

    @Override
    public void imprime(String mensagem) {
        this.resultado = mensagem;
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
