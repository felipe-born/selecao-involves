package br.com.involves.selecao.entrada_saida.usuario;

import br.com.involves.selecao.modelo.RetornoComando;
import org.junit.Test;

public class SaidaConsoleTest {

    @Test
    public void testarExecucaoDeComandosDeSaidaDeConsole() {
        SaidaConsole console = new SaidaConsole();

        console.boasVindas();
        console.solicitaComando();
        console.imprime(new RetornoComando("Testando execução de saída de console."));

    }

}