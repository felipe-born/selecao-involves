package br.com.involves.selecao.controlador;

import br.com.involves.selecao.modelo.Alerta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorDeAlertas {
    private List<Alerta> alertas = new ArrayList<>();

    public List<Alerta> getAlertas() {
        return Collections.unmodifiableList(alertas);
    }

    public void criaNovoAlerta(String mensagem) {
        alertas.add(new Alerta(LocalDateTime.now(), mensagem));
    }
}
