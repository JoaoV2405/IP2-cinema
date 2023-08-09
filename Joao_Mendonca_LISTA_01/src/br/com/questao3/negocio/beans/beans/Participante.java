package br.com.questao3.negocio.beans.beans;

import java.time.LocalDate;
import java.util.Scanner;

public class Participante extends Pessoa{
    private String trilhaInteresse;

    public Participante(long codigo, String email, String nome, LocalDate dataNascimento, String cidade, String trilhaInteresse) {
        super(codigo, email, nome, dataNascimento, cidade);
        setTrilhaInteresse(trilhaInteresse);
        this.trilhaInteresse = getTrilhaInteresse();
    }
    public String getTrilhaInteresse() {
        return trilhaInteresse;
    }

    public void setTrilhaInteresse(String trilhaInteresse) {
        switch (trilhaInteresse) {
            case "TECNOLOGIA", "CIDADES", "ECONOMIA_CRIATIVA":
                this.trilhaInteresse = trilhaInteresse;
                break;
            default:
                throw new RuntimeException("Trilha inválida");
        }
    }

    @Override
    public String toString() {
        return "Participante{"+ getNome() +" / código: "+ getCodigo()+" / email: "+ getEmail() +
                " / trilhaInteresse: " + trilhaInteresse  +
                '}'+ "\n";
    }

    @Override
    public int idade() {
        return super.idade();
    }


}
