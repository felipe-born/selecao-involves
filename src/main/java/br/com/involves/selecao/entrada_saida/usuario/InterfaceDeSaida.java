package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.modelo.Saida;

public interface InterfaceDeSaida<S extends Saida> {

    void solicitaComando();

    void imprime(S mensagem);

    void boasVindas();
}
