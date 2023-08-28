package com.example.cineurubufinal.exception;

public class SessaoOcupadaException extends Exception{
    private String tituloExistente;
    private int idSala;
    public SessaoOcupadaException(String titulo, int id){
        super("Não foi possível cadastrar " + titulo + " na sala de id "+ id + " pois a sessão já está ocupada");
        this.tituloExistente = titulo;
        this.idSala = id;
    }
    public int getIdSala(){
        return idSala;
    }
    public String getTituloExistente() {
        return tituloExistente;
    }
}

