package br.com.beans;

public class Assento {
    final int coluna = 11;
    final int linha = 10;
    String[] fileira = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    String[][] assentos = new String[linha][coluna];

    public void preencher(){
        for (int i = 0; i < linha; i++){
            for (int o = 1; o < coluna; o++){
                assentos[i][o] =  (fileira[i] + o );
                System.out.println(assentos[i][o]);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Assento assento = new Assento();
        assento.preencher();
    }
}
