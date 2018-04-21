package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;

import java.io.*;

public class EntradaConsole implements InterfaceDeEntrada<ControladorDeInterfaceDeUsuario> {
    private ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario;
    private InputStream inputStream;

    public EntradaConsole() {
        this.inputStream = System.in;
    }

    public EntradaConsole(InputStream inputStream) {

        this.inputStream = inputStream;
    }


    @Override
    public void aguardaEntrada() {
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha = leitor.readLine();
            controladorDeInterfaceDeUsuario.recebeComando(linha);
        } catch (IOException e) {
        }
    }

    @Override
    public void recebeControlador(ControladorDeInterfaceDeUsuario controlador) {
        this.controladorDeInterfaceDeUsuario = controlador;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
