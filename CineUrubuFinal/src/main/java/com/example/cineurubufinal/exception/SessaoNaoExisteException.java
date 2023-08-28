package com.example.cineurubufinal.exception;

public class SessaoNaoExisteException extends Exception{
    private int idSala;
    public SessaoNaoExisteException(String titulo, int id){
        super("Não foi possível excluir a sessao de id "+ id + " pois a sessão não existe");
        this.idSala = id;
    }
    public int getIdSala(){
        return idSala;
    }
}

