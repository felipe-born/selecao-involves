package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EntradaConsole implements InterfaceDeEntrada<ControladorDeInterfaceDeUsuario> {
    private ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario;
    InputStream inputStream;

    public EntradaConsole() {
        this.inputStream = System.in;
    }


    @Override
    public void aguardaEntrada() {
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha = leitor.readLine();
            controladorDeInterfaceDeUsuario.recebeComando(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recebeControlador(ControladorDeInterfaceDeUsuario controlador) {
        this.controladorDeInterfaceDeUsuario = controlador;
    }
}
