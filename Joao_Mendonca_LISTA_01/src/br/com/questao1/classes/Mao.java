package br.com.questao1.classes;

import java.util.ArrayList;

public class Mao {
    private ArrayList<Carta> maoDeck;

    public Mao() {
        maoDeck = new ArrayList<Carta>();
    }

    public ArrayList<Carta> getMaoDeck() {
        return maoDeck;
    }

    public void setMaoDeck(ArrayList<Carta> maoDeck) {
        this.maoDeck = maoDeck;
    }
    public void tirarCarta(Deck deck){
        this.maoDeck.add(deck.pegarCarta());
    }
    public int calcularValor(){
        int valor=0;
        int ace=0;
        for(Carta cartas: maoDeck){
            valor+=cartas.getValor().getValor();
            if(cartas.getValor().getValor() ==11){
                ace++;
            }
        }
        if(valor > 21 && ace>0){
            while(valor>21 && ace>0){
                ace--;
                valor-=10;
            }
        }
        return valor;
    }



    @Override
    public String toString() {
       String str = "";
       for(Carta carta: maoDeck){
           str += carta +"-";
       }
        return str.substring(0, str.length()-1);
    }

    public static void main(String[] args) {
        Deck deck1 = new Deck();
        Mao mao = new Mao();
        deck1.Shuffle();
        for (int i = 0; i < 4; i++) {
            mao.tirarCarta(deck1);
        }
        System.out.println(mao);
        System.out.println(mao.calcularValor());
        System.out.println(deck1);

    }
}
