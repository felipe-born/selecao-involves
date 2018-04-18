package br.com.involves.selecao.modelo;

public class ComandoNaoDefinidoHandler implements ComandoHandler {
    @Override
    public void exec(String comando) {
        System.out.println("Comando "+comando + " Ainda não foi implementado!");
    }
}
