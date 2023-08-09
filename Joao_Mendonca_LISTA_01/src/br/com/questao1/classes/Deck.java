package br.com.questao1.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    ArrayList<Carta> deck;

    public Deck() {

        preencherDeck();

    }
    public void preencherDeck() {
        int quantidade;
        System.out.println("Digite a quantidade de baralhos desejada(entre 2 e 10): ");
        do{
            Scanner scanner = new Scanner(System.in);
            quantidade = scanner.nextInt();
        }while(quantidade<2 || quantidade>10);
        ArrayList<Carta> baralho = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            for (Naipe naipe : Naipe.values()) {
                for (Valor valor : Valor.values()) {
                    baralho.add(new Carta(naipe, valor));
                }
            }
            this.deck = baralho;
        }
    }
    public void addCards(ArrayList<Carta> carta){
        deck.addAll(carta);
    }
    public Carta pegarCarta(){
        Carta carta = deck.get(0);
        deck.remove(0);
        return carta;
    }
    public void Shuffle(){
        Collections.shuffle(this.deck);
    }
    public ArrayList<Carta> getDeck() {
        return deck;
    }
    public boolean temCartas(){
        return deck.size() > 0;
    }
    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

    public static void main(String[] args) {
        Deck deck1 = new Deck();
        int q = 0;
        deck1.Shuffle();
        for (int i= 0; i< deck1.getDeck().size(); i++){
            System.out.println(deck1.getDeck().get(i).toString());
        }
        System.out.println(deck1.getDeck().size());
    }
}
