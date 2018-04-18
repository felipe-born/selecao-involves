package br.com.involves.selecao.modelo;

public class AjudaHandler implements ComandoHandler {
    @Override
    public void exec(String comando) {
        System.out.println("Você pode usar os seguintes comandos: olá, oi, alou");
    }
}
