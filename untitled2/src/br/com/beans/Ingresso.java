package br.com.beans;

import java.time.LocalDateTime;

public class Ingresso {
    private Usuario cliente;
    private Sessao sessao;
    private LocalDateTime hora;
    private Assento assento;
    private String tipo;
    private Filme filme;

    public Ingresso(Usuario cliente, Sessao sessao, LocalDateTime hora, Assento assento, String tipo, Filme filme){
        this.cliente = cliente;
        this.sessao = sessao;
        this.hora = hora;
        this.assento = assento;
        this.tipo = tipo;
        this.filme = filme;
    }
}
