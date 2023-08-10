package br.com.exception;

public class FilmeNaoExisteException extends Exception{
    private String Ntitulo;
    public FilmeNaoExisteException(String titulo){
        super("o filme " + titulo + " não existe!");
        this.Ntitulo = titulo;
    }

    public String getNTitulo() {
        return Ntitulo;
    }
}
