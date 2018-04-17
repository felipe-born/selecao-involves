package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

public class LinhaHandlerCSV implements LinhaHandler {
    @Override
    public EntidadeDeLeitura lidarCom(String conteudo) {
        return new EntidadeComPropriedades(conteudo);
    }
}
