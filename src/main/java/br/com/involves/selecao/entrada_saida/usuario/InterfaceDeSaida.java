package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;

public class InterfaceDeSaida {

    private final ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario;

    public InterfaceDeSaida(ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario) {

        this.controladorDeInterfaceDeUsuario = controladorDeInterfaceDeUsuario;
    }

    public void fala(String comando) {
        System.out.println("Recebi o comando: " + comando);
    }
}
