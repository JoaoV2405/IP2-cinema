package br.com.questao3.dados;

import br.com.questao3.negocio.beans.beans.Avaliacao;
import br.com.questao3.negocio.beans.beans.Palestra;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RepositorioPalestras implements IRepositorioPalestras{
    private ArrayList<Palestra> palestras;
    private static RepositorioPalestras instance;
    public RepositorioPalestras(){
        this.palestras = new ArrayList<>();
    }
    public static RepositorioPalestras getInstance() {
        if (instance == null){
            instance = new RepositorioPalestras();
        }
        return instance;
    }

    @Override
    public void inserirPalestra(Palestra p) {
        if(p != null) {
            long id = p.getId();
            boolean idIgual = false;
            for (Palestra pa : palestras) {
                if (pa.getId() == id) {
                    idIgual = true;
                    break;
                }
            }
            if(!idIgual){
                this.palestras.add(p);
            }
        }
    }

    @Override
    public Palestra buscarPalestraPorId(int id) {
        for (Palestra palestra : this.palestras) {
            if (palestra.getId() == id) {
                return palestra;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Palestra> listarPalestras() {
        return palestras;
    }

    @Override
    public ArrayList<Palestra> listarPalestrasComMediaAvaliacaIgualOuMaiorQue(int nota) {
        ArrayList<Palestra> palestraMedia = new ArrayList<>();
        for (int i = 0; i< this.palestras.size(); i++) {
            Palestra palestraN = this.palestras.get(i);
            if (palestraN.getAvaliacoes().get(i).getNota() >= nota){
                palestraMedia.add(palestraN);
            }
        }
        return palestraMedia;
    }


    @Override
    public ArrayList<Avaliacao> listarTodasAvaliacoes() {
        ArrayList<Avaliacao> todasAvaliacoes = new ArrayList<>();
        for (int i = 0; i< this.palestras.size(); i++) {
            Palestra palestraN = this.palestras.get(i);
            if (palestraN.getAvaliacoes()!= null){
                todasAvaliacoes.add(palestraN.getAvaliacoes().get(i));
            }
        }
        return todasAvaliacoes;
    }

    @Override
    public String toString() {
        return "RepositorioPalestras{" +
                "palestras: " + palestras  +
                '}';
    }

    @Override
    public Palestra buscarPalestrasPorLocalEHorario(String local, LocalDateTime horario) {
        for(Palestra palestra: this.palestras){
            if(palestra.getLocal().equals(local) && palestra.getDataHora().isEqual(horario)){
                return palestra;
            }
        }
        return null;
    }

    public ArrayList<Palestra> getPalestras() {
        return palestras;
    }
}
