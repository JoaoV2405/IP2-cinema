package br.com.negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sessao {
    private int id;
    private Filme filme;
    private LocalDateTime dataHora;
    private Assento assento;
     ArrayList<String> assentoOcupado;
    public Sessao(){
        Assento assento1 = new Assento();
        setAssento(assento1);
        assento.preencher();
        this.assentoOcupado = getAssentoOcupado();
    }
    public Sessao(Filme filme){
        this.assentoOcupado = getAssentoOcupado();
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

    public ArrayList<String> getAssentoOcupado() {
        return assentoOcupado;
    }
    public ArrayList<String> setAssentoOcupado(String ass) {
        ArrayList<String> merda = new ArrayList<>();
        merda.add(ass);
        this.assentoOcupado = merda;
        return assentoOcupado;
    }
    public static void main(String[] args) {
        Sessao sessao = new Sessao();
    }
}
