package br.com.involves.selecao.controlador;

import br.com.involves.selecao.comando.Comando;
import br.com.involves.selecao.modelo.RetornoComando;
import br.com.involves.selecao.conversor.ConversorEntradaComando;
import br.com.involves.selecao.dominio.TipoDeComando;
import br.com.involves.selecao.entrada_saida.usuario.EntradaIU;
import br.com.involves.selecao.entrada_saida.usuario.SaidaIU;
import br.com.involves.selecao.flyweight.Flyweight;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.EntradaComando;

import java.util.List;

public class ControladorInterfaceDeUsuario implements Controlador {
    private final EntradaComando entradaComando;
    private Flyweight<Comando> comandoHandlerFlyweight;

    private SaidaIU saida;
    private EntradaIU entrada;

    public ControladorInterfaceDeUsuario(List<EntidadeDeLeitura> entidadesDeLeitura,
                                         ConversorEntradaComando conversor,
                                         Flyweight<Comando> comandoHandlerFlyweight,
                                         EntradaIU entrada,
                                         SaidaIU saida) {

        this.entradaComando = conversor.converter(entidadesDeLeitura);
        this.comandoHandlerFlyweight = comandoHandlerFlyweight;
        this.entrada = entrada;
        this.saida = saida;
    }

    public void iniciaComunicacaoComUsuario() {
        entrada.recebeControlador(this);
        saida.boasVindas();
        aguardaComando();
    }

    public void recebeComando(String comando) {
        TipoDeComando tipoDeComando = TipoDeComando.getComandoCom(comando);

        Comando comandoHandler = comandoHandlerFlyweight.getInstance(tipoDeComando.getHandlerClazz());
        RetornoComando retorno = comandoHandler.exec(comando, entradaComando);
        saida.imprime(retorno);
        if (!retorno.indicaFimExecucao())
            aguardaComando();
    }

    private void aguardaComando() {
        saida.solicitaComando();
        entrada.aguardaEntrada();
    }

}
