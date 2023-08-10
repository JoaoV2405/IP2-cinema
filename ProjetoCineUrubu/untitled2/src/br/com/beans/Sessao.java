package br.com.beans;

import java.time.LocalDateTime;

public class Sessao {
    private int id;
    private Filme filme;
    private LocalDateTime dataHora;
    private Assento assento;
    public Sessao(){
        Assento assento1 = new Assento();
        setAssento(assento1);
        assento.preencher();
    }
    public Sessao(Filme filme){
        Assento assento1 = new Assento();
        this.filme = filme;
        setAssento(assento1);
        assento.preencher();
    }

    public Filme getFilme() {
        return filme;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getId() {
        return id;
    }

    public Assento getAssento() {
        assento.preencher();
        return assento;
    }

    public void setAssento(Assento assento) {

        this.assento = assento;
    }

    public static void main(String[] args) {
        Sessao sessao = new Sessao();
    }
}
