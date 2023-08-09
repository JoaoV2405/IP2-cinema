package br.com.questao3.negocio.beans;

import br.com.questao2.negocio.beans.beans.Midia;
import br.com.questao3.dados.IRepositorioPalestras;
import br.com.questao3.dados.IRepositorioPessoas;
import br.com.questao3.dados.RepositorioPalestras;
import br.com.questao3.dados.RepositorioPessoas;
import br.com.questao3.negocio.beans.beans.Avaliacao;
import br.com.questao3.negocio.beans.beans.Palestra;
import br.com.questao3.negocio.beans.beans.Participante;
import static java.util.Comparator.comparing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ControladorRECnPlay {
    private IRepositorioPessoas repPessoa;
    private IRepositorioPalestras repPalestra;
    private static ControladorRECnPlay instance;

    private ControladorRECnPlay(){
        this.repPessoa = RepositorioPessoas.getInstance();
        this.repPalestra = RepositorioPalestras.getInstance();
    }

    public static ControladorRECnPlay getInstance() {
        if(instance == null){
            instance = new ControladorRECnPlay();
        }
        return instance;
    }
    public void realizarInscricao(Participante p){
        if(p != null && p.getTrilhaInteresse() != null){
            this.repPessoa.inserirPessoa(p);
        }
    }
    public void cadastrarPalestra(Palestra p){
        if(p !=null && p.getTrilha()!=null){
            boolean Igual = false;
            this.repPessoa.inserirPessoa(p.getPalestrante());
            for (Palestra pa : repPalestra.getPalestras()) {
                if ( pa.getTitulo().equals(p.getTitulo()) || pa.getDataHora().isEqual(p.getDataHora())) {
                    Igual = true;
                    break;
                }
            }
            if (!Igual) {
                this.repPalestra.inserirPalestra(p);
            }
        }
    }
    public void avaliarPalestra(Avaliacao aval){
        if(aval.getAvaliador()!=null && aval.getPalestra()!=null){
            if(this.repPessoa.getPessoas().contains(aval.getAvaliador()) &&this.repPalestra.getPalestras().contains(aval.getPalestra())){
                aval.getPalestra().addAvaliacoes(aval);
            }
        }
    }
    public ArrayList<Palestra> listarPalestrasMaisBemAvaliadas() {
        ArrayList<Palestra> palestraBemAvaliada = new ArrayList<>();
        int a = 1;
        for(Palestra palestra: this.repPalestra.getPalestras()){
            palestra.setMedia();
            palestraBemAvaliada.add(palestra);
        }
        palestraBemAvaliada.sort(comparing(Palestra::getMedia));
        System.out.println("As Palestras mais bem avaliadas são: ");
        for(int i = palestraBemAvaliada.size(); i > 0; i--){

            System.out.println(a +": " + "'" + palestraBemAvaliada.get(i-1).getTitulo() + "'" +" com média: "+palestraBemAvaliada.get(i-1).getMedia() + "\n");
            a++;
        }
        return palestraBemAvaliada;
        }


    public ArrayList<Participante> listarParticipantesComIdadeMairQue(int idade) {
        return repPessoa.listarParticipantesComIdadeMairQue(idade);
    }

    public ArrayList<Palestra> getPalestras() {
        return repPalestra.getPalestras();
    }
      public int listarTotalPalestrasComMediaAvaliacaoMaiorQue(int nota){
        int total =0;
        for(int j=0; j < this.repPalestra.getPalestras().size();j++){
            Palestra palestra = this.repPalestra.getPalestras().get(j);
            palestra.setMedia();
        }
        for(int i=0; i < this.repPalestra.getPalestras().size();i++){
            if(this.repPalestra.getPalestras().get(i).getMedia() >= nota){
                total++;
            }
        }
        return total;
    }
}


