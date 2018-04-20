package br.com.involves.selecao.controlador;

import br.com.involves.selecao.comando.ComandoHandler;
import br.com.involves.selecao.conversor.ConversorEntidadeParaEntradaComando;
import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.entrada_saida.usuario.InterfaceDeEntrada;
import br.com.involves.selecao.entrada_saida.usuario.InterfaceDeSaida;
import br.com.involves.selecao.flyweight.Flyweight;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.EntradaDeComando;

import java.util.List;

public class ControladorDeInterfaceDeUsuario {
    private final EntradaDeComando entradaDeComando;
    private Flyweight<ComandoHandler> comandoHandlerFlyweight;

    private InterfaceDeSaida saida;
    private InterfaceDeEntrada entrada;

    public ControladorDeInterfaceDeUsuario(List<EntidadeDeLeitura> entidadesDeLeitura,
                                           ConversorEntidadeParaEntradaComando conversor,
                                           Flyweight<ComandoHandler> comandoHandlerFlyweight) {

        this.entradaDeComando = conversor.converter(entidadesDeLeitura);
        this.comandoHandlerFlyweight = comandoHandlerFlyweight;
    }

    public void iniciaComunicacaoComUsuario() {
        entrada = new InterfaceDeEntrada(this);
        saida = new InterfaceDeSaida(this);
        aguardaComando();
    }

    public void recebeComando(String comando) {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom(comando);

        ComandoHandler comandoHandler = comandoHandlerFlyweight.getInstance(tipoDeComando.getHandlerClazz());

        String retorno = comandoHandler.exec(comando, entradaDeComando);
        saida.imprime(retorno);

        aguardaComando();
    }

    private void aguardaComando() {
        saida.solicitaComando();
        entrada.aguardaEntrada();
    }

}
