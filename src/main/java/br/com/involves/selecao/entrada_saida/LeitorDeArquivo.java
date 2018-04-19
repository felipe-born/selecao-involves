package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.excecao.EntidadeDeLeituraException;
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try (Stream<String> stream = bufferedReader.lines()) {
            List<EntidadeDeLeitura> entidadesDeLeitura = stream
                    .map(conteudo -> {
                        try {
                            return linhaHandler.lidarCom(conteudo);
                        } catch (EntidadeDeLeituraException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(entidade -> entidade instanceof EntidadeComPropriedades)
                    .collect(Collectors.toList());
            return entidadesDeLeitura;
        } catch (Exception e) {
            throw new LeituraDeArquivoException(e);
        }
    }
}
