package br.com.exception;

public class AssentoOcupadoException extends Exception{
    public AssentoOcupadoException(){
        super("Assento ocupado!");
    }
}
