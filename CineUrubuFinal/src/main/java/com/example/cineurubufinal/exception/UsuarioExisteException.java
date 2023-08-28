package com.example.cineurubufinal.exception;

public class UsuarioExisteException extends Exception{
    private String email;
    private long cpf;
    public UsuarioExisteException(String email, long cpf){
        super("Já existe um usuário com o email " + email + " já existe!");
        this.cpf = cpf;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
