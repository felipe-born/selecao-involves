package br.com.involves.selecao.parser;

import br.com.involves.selecao.excecao.ParametroParserException;

import java.util.ArrayList;
import java.util.List;

public class AutomatoFinitoSeparadorPalavras {

    private ArrayList<String> palavras = new ArrayList<>();
    private StringBuilder textoAtual = new StringBuilder();

    /*
    Autômato finito:
    d: dígito qualquer
    _: espaço em branco
    ": delimitador de palavra

     _A -> A (faz nada)
     dA -> B (adiciona digito)
     "A -> C (inicia nova palavra)
     _B -> A (finaliza palavra)
     dB -> B (adiciona digito)
     "B -> C (finaliza palavras e inicia nova palavra)
     _C -> C (adiciona digito)
     dC -> C (adiciona digito)
     "C -> A (finaliza palavra)
     */

    public String[] separaPalavras(String texto, String textoDelimitadorDePalavras, String textoSeparadorDePalavras) {
        if (texto == null || textoDelimitadorDePalavras == null || textoSeparadorDePalavras == null)
            return new String[0];
        List<String> listaDePalavras = estadoAguardandoEntradaTexto(0, texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
        String[] palavras = new String[listaDePalavras.size()];
        return listaDePalavras.toArray(palavras);
    }

    private List<String> estadoAguardandoEntradaTexto(int indiceAtualTexto, String texto, String textoDelimitadorDePalavras, String textoSeparadorDePalavras) {
        if (indiceAtualTexto >= texto.length())
            return palavras;
        String subTextoAtual = texto.substring(indiceAtualTexto);
        if (subTextoAtual.startsWith(textoDelimitadorDePalavras)) {
            return estadoNovoTextoNoDelimitador(indiceAtualTexto + textoDelimitadorDePalavras.length(), texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
        }
        if (subTextoAtual.startsWith(textoSeparadorDePalavras)) {
            return estadoAguardandoEntradaTexto(indiceAtualTexto + textoSeparadorDePalavras.length(), texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
        }
        textoAtual.append(subTextoAtual.charAt(0));
        return estadoNovoTexto(indiceAtualTexto + 1, texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
    }

    private List<String> estadoNovoTexto(int indiceAtualTexto, String texto, String textoDelimitadorDePalavras, String textoSeparadorDePalavras) {
        if (indiceAtualTexto >= texto.length()) {
            String valorTextoAtual = textoAtual.toString();
            if (!valorTextoAtual.isEmpty())
                palavras.add(valorTextoAtual);
            return palavras;
        }
        String subTextoAtual = texto.substring(indiceAtualTexto);

        if (subTextoAtual.startsWith(textoDelimitadorDePalavras)) {
            palavras.add(textoAtual.toString());
            textoAtual = new StringBuilder();
            return estadoNovoTextoNoDelimitador(indiceAtualTexto + textoDelimitadorDePalavras.length(), texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
        }

        if (subTextoAtual.startsWith(textoSeparadorDePalavras)) {
            palavras.add(textoAtual.toString());
            textoAtual = new StringBuilder();
            return estadoAguardandoEntradaTexto(indiceAtualTexto + textoSeparadorDePalavras.length(), texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
        }

        textoAtual.append(subTextoAtual.charAt(0));
        return estadoNovoTexto(indiceAtualTexto + 1, texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
    }

    private List<String> estadoNovoTextoNoDelimitador(int indiceAtualTexto, String texto, String textoDelimitadorDePalavras, String textoSeparadorDePalavras) {
        if (indiceAtualTexto >= texto.length())
            throw new ParametroParserException("Texto não finalizado corretamente: " + texto);
        String subTextoAtual = texto.substring(indiceAtualTexto);
        if (subTextoAtual.startsWith(textoDelimitadorDePalavras)) {
            palavras.add(textoAtual.toString());
            textoAtual = new StringBuilder();
            return estadoAguardandoEntradaTexto(indiceAtualTexto + textoDelimitadorDePalavras.length(), texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
        }
        textoAtual.append(subTextoAtual.charAt(0));
        return estadoNovoTextoNoDelimitador(indiceAtualTexto + 1, texto, textoDelimitadorDePalavras, textoSeparadorDePalavras);
    }


}
