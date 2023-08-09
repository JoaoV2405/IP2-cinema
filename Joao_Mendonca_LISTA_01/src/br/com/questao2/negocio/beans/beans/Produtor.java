package br.com.questao2.negocio.beans.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Produtor extends Usuario{
    private String nomeCanal;
    private ArrayList<String> categorias;
    public Produtor(String email, String nomeCompleto, LocalDate dataNascimento, String nomeCanal) {
        super(email, nomeCompleto, dataNascimento);
        this.nomeCanal = nomeCanal;
         setCategorias(categorias);
        this.categorias = getCategorias();
    }
    public String getNomeCanal() {
        return nomeCanal;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public ArrayList<String> setCategorias(ArrayList<String>categorias) {
        System.out.println("Digite as categorias do produtor: ");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> categorias1 = new ArrayList<String>();
        while (true){
            String categoriaAux = scanner.next();
            if(categoriaAux.equals("x")){
                break;
            }else{
                categorias1.add(categoriaAux);
                this.categorias = categorias1;
            }
        }
        return categorias;
    }
    public ArrayList<String> getCategorias() {
        return categorias;
    }

    @Override
    public String toString() {
        return "Produtor{" +
                "nomeCanal='" + nomeCanal +
                ", categorias=" + categorias + "email= "+
                 getEmail()+ "\n";
    }
}
/*priivar construtor no repositorio*/
/*
criar atributo do proprio repo dentro do repo chamado instandce
private static repositorio
public static repositorio getinsance{if inance == nullretorna instance}
this.repositorio = =contasarray.getinstance()
*/
