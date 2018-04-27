package br.com.involves.selecao.builder;

import br.com.involves.selecao.comando.Comando;
import br.com.involves.selecao.controlador.ControladorInterfaceDeUsuario;
import br.com.involves.selecao.conversor.ConversorEntradaComando;
import br.com.involves.selecao.entrada_saida.usuario.EntradaIU;
import br.com.involves.selecao.entrada_saida.usuario.SaidaIU;
import br.com.involves.selecao.flyweight.Flyweight;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import javafx.util.Builder;

import java.util.List;

public class ControladorDeInterfaceDeUsuarioBuilder implements Builder<ControladorInterfaceDeUsuario> {
    private List<EntidadeDeLeitura> entidadesDeLeitura;
    private Flyweight<Comando> flyweight;
    private ConversorEntradaComando conversor;
    private EntradaIU entradaIU;
    private SaidaIU saidaIU;


    public ControladorDeInterfaceDeUsuarioBuilder comEntidades(List<EntidadeDeLeitura> entidadesDeLeitura) {
        this.entidadesDeLeitura = entidadesDeLeitura;
        return this;
    }

    public ControladorDeInterfaceDeUsuarioBuilder comComandoFlyweight(Flyweight<Comando> flyweight) {
        this.flyweight = flyweight;
        return this;
    }

    public ControladorDeInterfaceDeUsuarioBuilder comConversor(ConversorEntradaComando conversor) {

        this.conversor = conversor;
        return this;
    }

    public ControladorDeInterfaceDeUsuarioBuilder comInterfaceDeEntrada(EntradaIU entradaIU) {
        this.entradaIU = entradaIU;
        return this;
    }

    public ControladorDeInterfaceDeUsuarioBuilder comInterfaceDeSaida(SaidaIU saidaIU) {
        this.saidaIU = saidaIU;
        return this;
    }

    @Override
    public ControladorInterfaceDeUsuario build() {
        return new ControladorInterfaceDeUsuario(entidadesDeLeitura, conversor, flyweight, entradaIU, saidaIU);
    }
}
