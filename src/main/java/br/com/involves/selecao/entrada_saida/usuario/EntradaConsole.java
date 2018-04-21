package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntradaConsole implements InterfaceDeEntrada {
    private final ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario;

    public EntradaConsole(ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario) {

        this.controladorDeInterfaceDeUsuario = controladorDeInterfaceDeUsuario;
    }

    @Override
    public void aguardaEntrada() {
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in))) {
            String linha = leitor.readLine();
            controladorDeInterfaceDeUsuario.recebeComando(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
