package br.com.questao1;

import br.com.questao1.classes.Deck;
import br.com.questao1.classes.Player;

import java.util.Scanner;

public class Jogo2 {
    private Player player, dealer;
    private Deck deck, deckE;
    private int fichas;

    public Jogo2() {
        player = new Player("Jogador");
        dealer = new Player("Banca");
        deck = new Deck();
        deckE= deck;
        this.fichas =getFichas() ;
        deck.Shuffle();
        jogar();
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public int getFichas() {
        return fichas;
    }

    public void jogar() {
        setFichas(100);
        int disputa = 1;
        int aposta = 1;
        System.out.println("Bem-vindo ao Blackjack Rural" + "\n");
        while (fichas > 0) {
            boolean on = true;
            player.getMao().getMaoDeck().clear();
            dealer.getMao().getMaoDeck().clear();

            while(on){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Disputa nº" + disputa + "\n");
                System.out.println("Quantidade de cartas no montante: " + deck.getDeck().size());
                System.out.println("Quantidade de fichas:"+ fichas);
                /*loop aposta*/
                do{
                    System.out.println("Digite sua aposta(minimo de 2) ou 0 para sair: ");
                    aposta = scanner.nextInt();
                }while(aposta>fichas);

                if(aposta!=0){
                    /*inicio do jogo*/
                    dealer.getMao().tirarCarta(deck);
                    player.getMao().tirarCarta(deck);
                    player.getMao().tirarCarta(deck);
                    System.out.println("Essas são as cartas da banca:");
                    System.out.println(dealer.getMao().toString());
                    System.out.println("Valor: "+ dealer.calcularValor());
                    System.out.println("------x------");
                    System.out.println("Essas são suas cartas:");
                    System.out.println(player.getMao().toString());
                    System.out.println("Valor: "+ player.calcularValor());
                    player.hitOrStay(deck, deckE);
                    /*checar se o player tem 21 cartas ou menos*/
                    if(player.calcularValor()<=21){
                        /*banca pega cartas ate ultrapassar o numero de cartas do usuario*/
                        while((dealer.calcularValor() < 21) && (dealer.calcularValor() <= player.calcularValor())){
                            dealer.getMao().tirarCarta(deck);
                            System.out.println("Essas são as cartas da banca:");
                            System.out.println(dealer.getMao().toString());
                            System.out.println("Valor: "+ dealer.calcularValor());
                            System.out.println("------x------");
                            System.out.println("Essas são suas cartas:");
                            System.out.println(player.getMao().toString());
                        }
                    }
                    /*player tem mais de 21 cartas*/
                /*else{
                    fichas -=aposta;
                    System.out.println("Você estourou as 21 cartas e perdeu "+ aposta+" fichas");
                    disputa++;
                    on = false;
                }*/
                    /*banca tem mais cartas que player e nao estourou as 21*/
                    if(dealer.calcularValor()> player.calcularValor() && dealer.calcularValor()<=21||player.calcularValor()>21){
                        fichas -=aposta;
                        System.out.println("A banca ganhou e você perdeu: "+ aposta + " fichas");
                        disputa++;
                        on = false;
                        /*player ganha da banca*/
                    } else if (dealer.calcularValor()< player.calcularValor()||dealer.calcularValor()>21) {
                        fichas += aposta;
                        System.out.println("Você ganhou e recebeu "+ aposta+" fichas");
                        disputa++;
                        on = false;
                    } else if (player.calcularValor()== dealer.calcularValor()) {
                        System.out.println("Você e a banca empataram!");
                        disputa++;
                        on=false;
                    }
                }
                else return;
            }
        }

    }
    public void resultados(){
        if(this.fichas>0){
            int total = this.fichas -100;
            System.out.println("Parabéns, você ganhou " + total + " fichas");
            return;
        }
        else{
            System.out.println("Que pena! Você perdeu todas as fichas");
            return;
        }
    }

    public static void main(String[] args) {

        Jogo2 jogo = new Jogo2();
        jogo.resultados();
    }
}


