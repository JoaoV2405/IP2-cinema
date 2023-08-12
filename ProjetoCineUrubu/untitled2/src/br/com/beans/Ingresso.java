package br.com.beans;

import java.time.LocalDateTime;

public class Ingresso {
    private Usuario cliente;
    private Sessao sessao;
    private LocalDateTime hora;
    private Assento assento;
    private String tipo;
    private Filme filme;

    private int id;
    private double Preco;

    public Ingresso(Usuario cliente, Sessao sessao, LocalDateTime hora, Assento assento, String tipo, Filme filme){
        this.cliente = cliente;
        this.sessao = sessao;
        this.hora = hora;
        this.assento = assento;
        this.tipo = tipo;
        this.filme = filme;
    }

    public Usuario getCliente(){
        return cliente;
    }

    public Sessao getSessao(){
        return sessao;
    }

    public LocalDateTime getHora(){
        return hora;
    }

    public Assento getAssento(){
        return assento;
    }

    public String getTipo(){
        return tipo;
    }

    public Filme getFilme(){
        return filme;
    }

    public int getId(){
        return id;
    }

    public double setPreco(double preco){
        return Preco;
    }

    
}

