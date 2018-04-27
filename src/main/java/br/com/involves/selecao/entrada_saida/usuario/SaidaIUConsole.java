package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.comando.ComandoAjuda;
import br.com.involves.selecao.flyweight.ControleRemoto;
import br.com.involves.selecao.modelo.RetornoComando;

public class SaidaIUConsole implements SaidaIU<RetornoComando> {
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
        imprimeAjuda();
    }

    private void imprimeAjuda() {
        RetornoComando retornoComando = ControleRemoto.getInstancia()
                .getInstance(ComandoAjuda.class)
                .exec("help", null);
        imprime(retornoComando);
    }
}
