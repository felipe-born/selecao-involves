package br.com.involves.selecao.controlador;

import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.excecao.ValidacaoException;
import br.com.involves.selecao.fabrica.LeitorDeArquivoFactory;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import br.com.involves.selecao.validador.ValidadorDeParametrosAplicacao;

public class ControladorDaAplicacao {
    private final ControladorDeAlertas controladorDeAlertas;
    private final ParametrosAplicacao parametrosAplicacao;
    private final ValidadorDeParametrosAplicacao validadorDeParametrosAplicacao;

    private LeitorDeArquivo leitorDeArquivo;


    public ControladorDaAplicacao(ControladorDeAlertas controladorDeAlertas, ParametrosAplicacao parametrosAplicacao) {

        this.controladorDeAlertas = controladorDeAlertas;
        this.parametrosAplicacao = parametrosAplicacao;
        this.validadorDeParametrosAplicacao = new ValidadorDeParametrosAplicacao();
    }

    public void inicializaAplicacao() {

        validaParametrosAplicacao();
        inicializaLeitorDeArquivo();

        leitorDeArquivo.leia();

    }

    private void inicializaLeitorDeArquivo() {
        leitorDeArquivo = new LeitorDeArquivoFactory()
                .getLeitorDeArquivo()
                .doArquivo(parametrosAplicacao.getArquivo())
                .build();
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
