package br.com.questao1.classes;

public enum Naipe {
    COPAS("copas"), PAUS("paus"), OUROS("ouros"), ESPADAS("espadas");
    String nome;

    Naipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
