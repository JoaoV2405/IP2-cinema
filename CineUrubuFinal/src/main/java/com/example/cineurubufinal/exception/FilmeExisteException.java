package com.example.cineurubufinal.exception;

public class FilmeExisteException extends Exception{
    private String tituloExistente;
    public FilmeExisteException(String titulo){
        super("o filme " + titulo + " já existe!");
        this.tituloExistente = titulo;
    }

    public String getTituloExistente() {
        return tituloExistente;
    }
}
