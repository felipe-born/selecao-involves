package br.com.involves.selecao.model;

import java.time.LocalDateTime;

public class Alerta {

    public final LocalDateTime dataDoAlerta;
    public final String mensagemDoAlerta;

    public Alerta(LocalDateTime dataDoAlerta, String mensagemDoAlerta) {
        this.dataDoAlerta = dataDoAlerta;
        this.mensagemDoAlerta = mensagemDoAlerta;
    }
}
