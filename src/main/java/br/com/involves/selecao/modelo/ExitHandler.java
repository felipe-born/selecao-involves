package br.com.involves.selecao.modelo;

public class ExitHandler implements ComandoHandler {
    @Override
    public void exec(String comando) {
        System.out.println("Saindo do programa!!!!");
        System.exit(0);
    }
}
