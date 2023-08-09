package br.com.questao1.classes;

public enum Valor {
        A(11, "As"),DOIS(2, "Dois"), TRES(3,"Tres"), QUATRO(4,"Quatro"), CINCO(5, "Cinco"), SEIS(6,"Seis"), SETE(7,"Sete"),
        OITO(8, "Oito"), NOVE(9, "Nove"), DEZ(10,"Dez"), J(10,"Coringa"), Q(10,"Rainha"), K(10,"Rei");
        private int valor;
        private String nome;
        Valor(int valor, String nome) {
            this.nome = nome;
            this.valor = valor;
        }

    public int getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
}

