package br.com.involves.selecao.entrada_saida.usuario;

public class SaidaConsole implements InterfaceDeSaida {
    @Override
    public void solicitaComando() {
        imprime("Por favor, digite um comando: ");
    }

    @Override
    public void imprime(String mensagem) {
        System.out.printf(mensagem);
    }

    @Override
    public void boasVindas() {
        imprime("======================== Involves APP ========================");
        imprime("========== Felipe Born de Jesus __ Futuro Involvido ==========");
    }
}
