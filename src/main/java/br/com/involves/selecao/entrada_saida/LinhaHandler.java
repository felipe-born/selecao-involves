package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

public interface LinhaHandler {
    EntidadeDeLeitura lidarCom(String conteudo) throws EntidadeDeLeituraException;
}
