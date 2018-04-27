package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.controlador.Controlador;

public interface EntradaIU<T extends Controlador> {

    void aguardaEntrada();

    void recebeControlador(T controlador);
}
