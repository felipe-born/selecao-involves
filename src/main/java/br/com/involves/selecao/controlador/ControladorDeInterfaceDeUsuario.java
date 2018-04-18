package br.com.involves.selecao.controlador;

import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.entrada_saida.usuario.InterfaceDeEntrada;
import br.com.involves.selecao.entrada_saida.usuario.InterfaceDeSaida;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

import java.util.Collections;
import java.util.List;

public class ControladorDeInterfaceDeUsuario {
    private final List<EntidadeDeLeitura> entidadesDeLeitura;
    private InterfaceDeSaida saida;
    private InterfaceDeEntrada entrada;

    public ControladorDeInterfaceDeUsuario(List<EntidadeDeLeitura> entidadesDeLeitura) {

        this.entidadesDeLeitura = Collections.unmodifiableList(entidadesDeLeitura);
    }

    public void iniciaComunicacaoComUsuario() {
        entrada = new InterfaceDeEntrada(this);
        saida = new InterfaceDeSaida(this);

        saida.fala("Por favor, digite um comando: ");

        entrada.aguardaEntrada();
    }

    public void recebeComando(String comando) {

        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom(comando);
        tipoDeComando.getHandler().exec(comando);



        saida.fala(comando);
        entrada.aguardaEntrada();
    }

}
