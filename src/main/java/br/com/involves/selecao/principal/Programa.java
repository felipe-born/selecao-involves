package br.com.involves.selecao.principal;

public class Programa {

    /**
     * Main class. Apenas delega invocação para método não estático.
     *
     * @param args
     */
    public static void main(String[] args) {
        InvolveApp app = new InvolveApp(args);
        app.run();
    }
}
