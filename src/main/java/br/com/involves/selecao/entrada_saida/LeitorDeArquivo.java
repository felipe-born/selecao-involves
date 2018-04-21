package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.excecao.LeituraDeArquivoException;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.EntidadeComPropriedades;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeitorDeArquivo {

    private final LinhaHandler linhaHandler;
    private ArquivoDeLeitura arquivo;

    public LeitorDeArquivo(LinhaHandler linhaHandler, ArquivoDeLeitura arquivo) {

        this.linhaHandler = linhaHandler;
        this.arquivo = arquivo;
    }


    public List<EntidadeDeLeitura> leia() throws LeituraDeArquivoException {
        InputStream inputStream = arquivo.getInputStream();

        try (Stream<String> stream = new BufferedReader(new InputStreamReader(inputStream)).lines()) {
            List<EntidadeDeLeitura> entidadesDeLeitura = stream
                    .map(conteudo -> linhaHandler.lidarCom(conteudo))
                    .filter(entidade -> entidade instanceof EntidadeComPropriedades)
                    .collect(Collectors.toList());
            return entidadesDeLeitura;
        } catch (Exception e) {
            throw new LeituraDeArquivoException(e);
        }
    }
}
