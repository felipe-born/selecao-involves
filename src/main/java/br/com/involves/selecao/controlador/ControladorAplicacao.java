package br.com.involves.selecao.controlador;

import br.com.involves.selecao.conversor.ConversorDadosComPropriedades;
import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.entrada_saida.usuario.EntradaIUConsole;
import br.com.involves.selecao.entrada_saida.usuario.SaidaIUConsole;
import br.com.involves.selecao.excecao.LeituraDeArquivoException;
import br.com.involves.selecao.excecao.ValidacaoException;
import br.com.involves.selecao.fabrica.ControladorDeInterfaceDeUsuarioFactory;
import br.com.involves.selecao.fabrica.LeitorDeArquivoFactory;
import br.com.involves.selecao.flyweight.ControleRemoto;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import br.com.involves.selecao.validador.ValidadorDeParametrosAplicacao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ControladorAplicacao implements Controlador {
    private final ControladorAlertas controladorAlertas;
    private final ParametrosAplicacao parametrosAplicacao;
    private final ValidadorDeParametrosAplicacao validadorDeParametrosAplicacao;

    private InputStream inputStream;
    private LeitorDeArquivo leitorDeArquivo;
    private ControladorInterfaceDeUsuario controladorInterfaceDeUsuario;


    public ControladorAplicacao(ControladorAlertas controladorAlertas,
                                ParametrosAplicacao parametrosAplicacao,
                                InputStream inputStream) {

        this.controladorAlertas = controladorAlertas;
        this.parametrosAplicacao = parametrosAplicacao;
        this.inputStream = inputStream;
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

        controladorInterfaceDeUsuario = new ControladorDeInterfaceDeUsuarioFactory()
                .getControladorDeInterface()
                .comEntidades(entidadesDeLeitura)
                .comComandoFlyweight(ControleRemoto.getInstancia())
                .comConversor(new ConversorDadosComPropriedades())
                .comInterfaceDeEntrada(new EntradaIUConsole(inputStream))
                .comInterfaceDeSaida(new SaidaIUConsole())
                .build();

        controladorInterfaceDeUsuario.iniciaComunicacaoComUsuario();
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
            throw new RuntimeException(e);
        }
    }
}
