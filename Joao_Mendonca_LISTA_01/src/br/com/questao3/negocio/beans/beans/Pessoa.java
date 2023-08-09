package br.com.questao3.negocio.beans.beans;

import java.time.LocalDate;

public abstract class Pessoa {
        private long codigo;
        private String email;
        private String nome;
        private LocalDate dataNascimento;
        private String Cidade;

    public Pessoa(long codigo, String email, String nome, LocalDate dataNascimento, String cidade) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        Cidade = cidade;
    }

    public Pessoa(long codigo, String email, String nome) {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }
    public int idade(){
        return (2022 - dataNascimento.getYear());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "codigo=" + codigo +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", Cidade='" + Cidade + '\'' +
                '}'+ "\n";
    }

}
