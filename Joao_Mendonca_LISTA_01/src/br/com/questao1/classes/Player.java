package br.com.questao1.classes;

import java.util.Scanner;

public class Player {
private Mao maoJ;
private String nome;
    public Player(String nome) {
        this.nome = nome;
        maoJ= new Mao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void hitOrStay(Deck deck, Deck deck2){
        if(!(deck.temCartas())){
            deck.getDeck().clear();
            deck.addCards(deck2.getDeck());
            deck.Shuffle();
        }
            String escolha;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pressione 'h' pra pedir ou 's' para ficar: ");
            escolha= scanner.next();
            switch (escolha) {
                case "h" -> {
                    if(deck.temCartas()){
                        maoJ.tirarCarta(deck);
                        System.out.println("Essas são suas cartas:");
                        System.out.println(maoJ.getMaoDeck().toString());
                        System.out.println("Valor: "+ maoJ.calcularValor());
                        if(maoJ.calcularValor()>20){
                            return;
                        }
                        else{
                            this.hitOrStay(deck, deck2);
                        }
                    }
                }
                case "s" -> {
                    System.out.println("Você ficou.");
                }
            }

    }
    public Mao getMao() {
        return maoJ;
    }

    public int calcularValor() {
        return maoJ.calcularValor();
    }

    public void setMao(Mao mao) {
        this.maoJ = mao;
    }
}
