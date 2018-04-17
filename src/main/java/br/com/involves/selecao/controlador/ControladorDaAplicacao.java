package br.com.involves.selecao.controlador;

import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.model.ParametrosAplicacao;

public class ControladorDaAplicacao {
    private final ControladorDeAlertas controladorDeAlertas;
    private final ParametrosAplicacao parametrosAplicacao;
    private LeitorDeArquivo leitorDeArquivo;



    public ControladorDaAplicacao(ControladorDeAlertas controladorDeAlertas, ParametrosAplicacao parametrosAplicacao) {

        this.controladorDeAlertas = controladorDeAlertas;
        this.parametrosAplicacao = parametrosAplicacao;
    }

    public void inicializaAplicacao() {


    }
}
