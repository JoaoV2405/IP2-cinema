package com.example.cineurubufinal.negocio.beans;

import java.time.LocalDateTime;

public class Ingresso {
    private Usuario cliente;
    private Sessao sessao;
    private LocalDateTime hora;
    private Assento assento;
    private String tipo;
    private String filme;

    private int id;
    private double preco;
    public Ingresso(Sessao sessao){
        this.sessao = sessao;
    }
    public Ingresso(Assento assento){
        this.assento = assento;
    }
    public Ingresso(Usuario cliente, Sessao sessao, LocalDateTime hora,  String tipo, String filme){
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

    public String getFilme(){
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public int getId(){
        return id;
    }

    public void setPreco(){
        if(tipo.equals("Meia")){this.preco = 15;}
        else{this.preco = 30;}
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  filme + ", " + assento.getLabel() ;
    }
}

