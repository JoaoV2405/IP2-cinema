package br.com.beans;

import java.time.LocalTime;

public class Filme {
    private LocalTime duracao;
    private String titulo;
    private String genero;
    private String sinopse;
    private int faixaEtaria;

    public Filme(String titulo,String genero, String sinopse,int faixaEtaria, LocalTime duracao){
        this.duracao = duracao;
        this.genero = genero;
        this.sinopse = sinopse;
        this.faixaEtaria = faixaEtaria;
        this.titulo = titulo;
    }
    public Filme(String titulo,String genero, String sinopse,int faixaEtaria){
        this.genero = genero;
        this.sinopse = sinopse;
        this.faixaEtaria = faixaEtaria;
        this.titulo = titulo;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

}
