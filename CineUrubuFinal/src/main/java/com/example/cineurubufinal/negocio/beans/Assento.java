package com.example.cineurubufinal.negocio.beans;

public class Assento {
    int coluna;
    char fileira;
    Boolean ocupado = false;
    public Assento (char fileira, int coluna, Boolean ocupado){
        this.fileira = fileira;
        this.coluna = coluna;
        this.ocupado = ocupado;
    }

    public String getLabel() {
        return fileira + String.valueOf(coluna);
    }


    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }


}
