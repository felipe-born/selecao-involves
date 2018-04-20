package br.com.involves.selecao.builder;

import br.com.involves.selecao.dominio.TipoDeArquivo;
import br.com.involves.selecao.entrada_saida.LeitorDeArquivo;
import br.com.involves.selecao.entrada_saida.LinhaHandler;
import br.com.involves.selecao.excecao.TipoDeArquivoNaoSuportadoException;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.ParametrosAplicacao;
import br.com.involves.selecao.utilitarios.UtilitarioArquivo;
import javafx.util.Builder;

import java.io.FileNotFoundException;

public class LeitorDeArquivoBuilder implements Builder<LeitorDeArquivo> {

    private ArquivoDeLeitura arquivo;
    private LinhaHandler linhaHandler;

    public LeitorDeArquivoBuilder(ParametrosAplicacao parametrosAplicacao) throws FileNotFoundException {
        String extensaoArquivo = UtilitarioArquivo.getExtensao(parametrosAplicacao.getArquivo());
        TipoDeArquivo tipoDeArquivo = TipoDeArquivo.getTipoDeArquivo(extensaoArquivo);
        if (tipoDeArquivo == null)
            throw new TipoDeArquivoNaoSuportadoException(parametrosAplicacao.getArquivo());
        this.linhaHandler = tipoDeArquivo.getLinhaHandler();

        this.arquivo = new ArquivoDeLeituraBuilder(parametrosAplicacao)
                .comArquivo(parametrosAplicacao.getArquivo())
                .build();
    }

    @Override
    public LeitorDeArquivo build() {
        return new LeitorDeArquivo(linhaHandler, arquivo);
    }
}
