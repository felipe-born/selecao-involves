package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.modelo.RetornoComando;

public class SaidaConsole implements InterfaceDeSaida<RetornoComando> {
    @Override
    public void solicitaComando() {
        imprime("Por favor, digite um comando: ");
    }

    @Override
    public void imprime(RetornoComando mensagem) {
        this.imprime(mensagem.toString());
    }

    public void imprime(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void boasVindas() {
        imprime("======================== Involves APP ========================");
        imprime("========== Felipe Born de Jesus __ Futuro Involvido ==========");
    }
}
