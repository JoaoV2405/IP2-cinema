package br.com.negocio.beans;

import java.time.LocalDateTime;

public class Ingresso {
    private Usuario cliente;
    private Sessao sessao;
    private LocalDateTime hora;
    private String assento;
    private String tipo;
    private Filme filme;

    private int id;
    private double preco;
    public Ingresso(Sessao sessao){
        this.sessao = sessao;
    }
    public Ingresso(Usuario cliente, Sessao sessao, LocalDateTime hora,  String tipo, Filme filme){
        this.cliente = cliente;
        this.sessao = sessao;
        this.hora = hora;
        //this.assento = assento;
        this.tipo = tipo;
        this.filme = filme;
        this.preco = getPreco();
    }

    public Usuario getCliente(){
        return cliente;
    }

    public double getPreco() {
        return preco;
    }

    public Sessao getSessao(){
        return sessao;
    }

    public LocalDateTime getHora(){
        return hora;
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

    public void setPreco(double preco){
        if(tipo.equals("meia")){this.preco = 15;}
        else{this.preco = 30;}
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }
}

