package br.com.questao2.negocio.beans.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Consumidor extends Usuario{
    private ArrayList<String> categoriasInteresse;

    public Consumidor(String email, String nomeCompleto, LocalDate dataNascimento) {
        super(email, nomeCompleto, dataNascimento);
        setCategoriasInteresse(categoriasInteresse);
        this.categoriasInteresse = getCategoriasInteresse();
    }

    public ArrayList<String> getCategoriasInteresse() {
        return categoriasInteresse;
    }
    public ArrayList<String> setCategoriasInteresse(ArrayList<String>categoriasInteresse) {
        System.out.println("Digite as categorias de interesse do consumidor ou 'x' para sair: ");
        Scanner scanner2 = new Scanner(System.in);
        ArrayList<String> categoriasI1 = new ArrayList<String>();
        while (true){
            String categoriaIAux = scanner2.next();
            if(categoriaIAux.equals("x")){
                break;
            }else{
                categoriasI1.add(categoriaIAux);
                this.categoriasInteresse = categoriasI1;
            }
        }
        return categoriasInteresse;
    }

    @Override
    public String toString() {
        return "Consumidor: " +
                "categoriasInteresse=" + categoriasInteresse + " " + getEmail() +
                  "\n";
    }
}
/**/