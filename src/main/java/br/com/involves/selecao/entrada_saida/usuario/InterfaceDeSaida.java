package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;

public class InterfaceDeSaida {

    private final ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario;

    public InterfaceDeSaida(ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario) {

        this.controladorDeInterfaceDeUsuario = controladorDeInterfaceDeUsuario;
    }

    public void solicitaComando() {
        System.out.println(("Por favor, digite um comando: "));
    }

    public void imprime(String exec) {
        System.out.println(exec);
    }
}
