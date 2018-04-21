package br.com.involves.selecao.controlador;

import br.com.involves.selecao.conversor.ConversorConjuntoDadosComPropriedades;
import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.entrada_saida.usuario.EntradaConsole;
import br.com.involves.selecao.entrada_saida.usuario.SaidaConsole;
import br.com.involves.selecao.excecao.LeituraDeArquivoException;
import br.com.involves.selecao.excecao.ValidacaoException;
import br.com.involves.selecao.fabrica.ControladorDeInterfaceDeUsuarioFactory;
import br.com.involves.selecao.fabrica.LeitorDeArquivoFactory;
import br.com.involves.selecao.flyweight.ControleRemoto;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import br.com.involves.selecao.validador.ValidadorDeParametrosAplicacao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ControladorDaAplicacao {
    private final ControladorDeAlertas controladorDeAlertas;
    private final ParametrosAplicacao parametrosAplicacao;
    private final ValidadorDeParametrosAplicacao validadorDeParametrosAplicacao;

    private LeitorDeArquivo leitorDeArquivo;
    private ControladorDeInterfaceDeUsuario controladorDeInterfaceDeUsuario;


    public ControladorDaAplicacao(ControladorDeAlertas controladorDeAlertas, ParametrosAplicacao parametrosAplicacao) {

        this.controladorDeAlertas = controladorDeAlertas;
        this.parametrosAplicacao = parametrosAplicacao;
        this.validadorDeParametrosAplicacao = new ValidadorDeParametrosAplicacao();
    }

    public void inicializaAplicacao() {

        validaParametrosAplicacao();
        List<EntidadeDeLeitura> entidadesDeLeitura = new ArrayList<>();
        try {
            inicializaLeitorDeArquivo();
            entidadesDeLeitura = leitorDeArquivo.leia();
        } catch (LeituraDeArquivoException e) {
            e.printStackTrace();
        }

        controladorDeInterfaceDeUsuario = new ControladorDeInterfaceDeUsuarioFactory()
                .getControladorDeInterface()
                .comEntidades(entidadesDeLeitura)
                .comComandoFlyweight(ControleRemoto.getInstancia())
                .comConversor(new ConversorConjuntoDadosComPropriedades())
                .comInterfaceDeEntrada(new EntradaConsole())
                .comInterfaceDeSaida(new SaidaConsole())
                .build();

        controladorDeInterfaceDeUsuario.iniciaComunicacaoComUsuario();
    }

    private void inicializaLeitorDeArquivo() throws LeituraDeArquivoException {
        try {
            leitorDeArquivo = new LeitorDeArquivoFactory()
                    .getLeitorDeArquivo(parametrosAplicacao)
                    .build();
        } catch (FileNotFoundException ex) {
            throw new LeituraDeArquivoException(ex);
        }
    }

    private void validaParametrosAplicacao() {
        try {
            validadorDeParametrosAplicacao.valida(parametrosAplicacao);
        } catch (ValidacaoException e) {
            System.out.println("Ocorreu problema na aplicação: " + e.getMessage());
            System.out.println("Aplicação finalizada com erro");
            System.exit(1);
        }
    }
}
