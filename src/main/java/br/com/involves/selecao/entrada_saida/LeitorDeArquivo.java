package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.excecao.LeituraDeArquivoException;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeitorDeArquivo {

    private final LinhaHandler linhaHandler;
    private String arquivo;

    public LeitorDeArquivo(LinhaHandler linhaHandler, String arquivo) {

        this.linhaHandler = linhaHandler;
        this.arquivo = arquivo;
    }


    public List<EntidadeDeLeitura> leia() throws LeituraDeArquivoException {
        try (Stream<String> stream = Files.lines(Paths.get(arquivo))) {
            List<EntidadeDeLeitura> entidadesDeLeitura = stream
                    .map(conteudo -> linhaHandler.lidarCom(conteudo))
                    .collect(Collectors.toList());
            return entidadesDeLeitura;

        } catch (IOException exception) {
            throw new LeituraDeArquivoException(exception);
        }
    }
}
