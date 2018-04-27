package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorInterfaceDeUsuario;

import java.io.*;

public class EntradaIUConsole implements EntradaIU<ControladorInterfaceDeUsuario> {
    private ControladorInterfaceDeUsuario controladorInterfaceDeUsuario;
    private InputStream inputStream;

    public EntradaIUConsole(InputStream inputStream) {

        this.inputStream = inputStream;
    }


    @Override
    public void aguardaEntrada() {
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha = leitor.readLine();
            controladorInterfaceDeUsuario.recebeComando(linha);
        } catch (IOException e) {
        }
    }

    @Override
    public void recebeControlador(ControladorInterfaceDeUsuario controlador) {
        this.controladorInterfaceDeUsuario = controlador;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
