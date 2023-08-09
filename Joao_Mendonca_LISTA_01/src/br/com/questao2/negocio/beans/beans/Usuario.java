package br.com.questao2.negocio.beans.beans;

import java.time.LocalDate;

public abstract class Usuario {
    private String email;
    private String nomeCompleto;
    private LocalDate dataNascimento;

    public Usuario(String email, String nomeCompleto, LocalDate dataNascimento) {
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /*pega o ano do usuario*/
    public int ano(){
        return (2022 - dataNascimento.getYear()) ;
    }

    @Override
    public String toString() {
        return "Usuario:" +
                "email='" + email +
                "nomeCompleto='" + nomeCompleto  +
                "dataNascimento=" + dataNascimento +
                '}' + "\n";
    }
}
