package br.com.involves.selecao.builder;

import br.com.involves.selecao.comando.ComandoHandler;
import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;
import br.com.involves.selecao.conversor.ConversorEntidadeParaEntradaComando;
import br.com.involves.selecao.flyweight.Flyweight;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import javafx.util.Builder;

import java.util.List;

public class ControladorDeInterfaceDeUsuarioBuilder implements Builder<ControladorDeInterfaceDeUsuario> {
    private List<EntidadeDeLeitura> entidadesDeLeitura;
    private Flyweight<ComandoHandler> flyweight;
    private ConversorEntidadeParaEntradaComando conversor;


    public ControladorDeInterfaceDeUsuarioBuilder comEntidades(List<EntidadeDeLeitura> entidadesDeLeitura) {
        this.entidadesDeLeitura = entidadesDeLeitura;
        return this;
    }

    public ControladorDeInterfaceDeUsuarioBuilder comComandoFlyweight(Flyweight<ComandoHandler> flyweight) {
        this.flyweight = flyweight;
        return this;
    }

    public ControladorDeInterfaceDeUsuarioBuilder comConversor(ConversorEntidadeParaEntradaComando conversor) {

        this.conversor = conversor;
        return this;
    }

    @Override
    public ControladorDeInterfaceDeUsuario build() {
        return new ControladorDeInterfaceDeUsuario(entidadesDeLeitura, conversor, flyweight);
    }
}
