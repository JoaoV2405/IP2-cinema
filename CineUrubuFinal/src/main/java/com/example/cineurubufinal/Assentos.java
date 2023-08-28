package com.example.cineurubufinal;

import com.example.cineurubufinal.negocio.beans.Assento;

import java.util.ArrayList;

public class Assentos {


    public ArrayList<Assento> criarAssentos(ArrayList<Assento> a){
        for (char i = 'A'; i < 'K'; i++){
            for (int o = 1; o < 11; o++){
                Assento assento = new Assento(i, o , false);
                a.add(assento);
            }
        }
        return a;
    }

   /* public boolean achar(String posicao){
        for (int i = 0; i < 100; i++){
                if(Main.listaAssentos.get(i).getLabel().equals(posicao)){
                    return true;
            }
        }
        return false;
    }
    */
}
