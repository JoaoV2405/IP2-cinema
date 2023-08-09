package br.com.questao3.negocio.beans.beans;

import java.time.LocalDate;

public class Palestrante extends Pessoa{
    private String empresa;

    public Palestrante(long codigo, String email, String nome, LocalDate dataNascimento, String cidade, String empresa) {
        super(codigo, email, nome, dataNascimento, cidade);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Palestrante{" + "nome: " +getNome() + '\'' +
                "empresa:" + empresa + '\'' +
                '}'+ "\n";
    }
}
