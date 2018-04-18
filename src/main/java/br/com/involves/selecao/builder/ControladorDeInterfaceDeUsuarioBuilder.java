package br.com.involves.selecao.builder;

import br.com.involves.selecao.controlador.ControladorDeInterfaceDeUsuario;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import javafx.util.Builder;

import java.util.List;

public class ControladorDeInterfaceDeUsuarioBuilder implements Builder<ControladorDeInterfaceDeUsuario> {
    private List<EntidadeDeLeitura> entidadesDeLeitura;

    public ControladorDeInterfaceDeUsuarioBuilder comEntidades(List<EntidadeDeLeitura> entidadesDeLeitura) {
        this.entidadesDeLeitura = entidadesDeLeitura;
        return this;
    }

    @Override
    public ControladorDeInterfaceDeUsuario build() {
        return new ControladorDeInterfaceDeUsuario(entidadesDeLeitura);
    }
}
