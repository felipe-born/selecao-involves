package br.com.involves.selecao.entrada_saida;

import br.com.involves.selecao.excecao.LeituraDeArquivoException;
import br.com.involves.selecao.modelo.ArquivoDeLeitura;
import br.com.involves.selecao.modelo.EntidadeDeLeitura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        File file = new File(arquivo.getCaminhoArquivo());
        boolean ehArquivo = file.isFile();

        String caminhoArquivo = "resources/" + arquivo.getCaminhoArquivo();
        try (Stream<String> stream = Files.lines(Paths.get(caminhoArquivo))) {
            List<EntidadeDeLeitura> entidadesDeLeitura = stream
                    .map(conteudo -> linhaHandler.lidarCom(conteudo))
                    .collect(Collectors.toList());
            return entidadesDeLeitura;

        } catch (IOException exception) {
            throw new LeituraDeArquivoException(exception);
        }
    }
}
