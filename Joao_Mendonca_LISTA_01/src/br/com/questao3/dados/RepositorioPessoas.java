package br.com.questao3.dados;

import br.com.questao3.negocio.beans.beans.Palestrante;
import br.com.questao3.negocio.beans.beans.Participante;
import br.com.questao3.negocio.beans.beans.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioPessoas implements IRepositorioPessoas{
    private ArrayList<Pessoa> pessoas;
    private static RepositorioPessoas instance2;
    public RepositorioPessoas(){
        this.pessoas = new ArrayList<>();
    }
    public static RepositorioPessoas getInstance() {
        if (instance2 == null){
            instance2 = new RepositorioPessoas();
        }
        return instance2;
    }
    @Override
    public void inserirPessoa(Pessoa pessoa) {
        if(pessoa != null){
            String email = pessoa.getEmail();
            boolean emailIgual = false;
            for (Pessoa p : pessoas) {
                if (p.getEmail().equals(email)) {
                    emailIgual = true;
                    break;
                }
            }
            if (!emailIgual) {
                this.pessoas.add(pessoa);
            }
        }
    }


    @Override
    public void removerPessoa(String email) {
        boolean usuarioExiste = false;

        int i;
        for (i = 0; i < this.pessoas.size() && !usuarioExiste; i++) {
            Pessoa pessoa = this.pessoas.get(i);
            if (pessoa.getEmail().equals(email)) {
                usuarioExiste = true;
            }
        }
        if (usuarioExiste) {
            this.pessoas.remove(i-1);
        }
    }


    @Override
    public Pessoa buscarPessoaPorEmail(String email) {
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Palestrante> listarPalestrantesPorEmpresa(String empresa) {
        ArrayList<Palestrante> palestranteEmpresa = new ArrayList<>();
        for (Pessoa palestrante : this.pessoas) {
            if (((Palestrante)palestrante).getEmpresa().equals(empresa)) {
                palestranteEmpresa.add((Palestrante) palestrante);
            }
        }
        return palestranteEmpresa;
    }

    @Override
    public ArrayList<Participante> listarParticipantesComInteresseEm(String trilha) {
        ArrayList<Participante> participanteInteresse = new ArrayList<>();
        for (Pessoa participante : this.pessoas) {
            if (((Participante)participante).getTrilhaInteresse().equals(trilha)) {
                participanteInteresse.add((Participante) participante);
            }
        }
        return participanteInteresse;
    }

    @Override
    public ArrayList<Participante> listarParticipantesComIdadeMairQue(int idade) {
        ArrayList<Participante> participantesIdade = new ArrayList<>();
        for (Pessoa participanteI : this.pessoas) {
            if (participanteI instanceof Participante && participanteI.idade()>= idade) {
                participantesIdade.add((Participante) participanteI);
            }
        }
        System.out.println("Os participantes maiores que "+ idade +" são:");
        for(int i = 0; i < participantesIdade.size(); i++){
            System.out.println("-" + participantesIdade.get(i).getNome() + " com "+ participantesIdade.get(i).idade()+" anos"+ "\n");
        }
        return participantesIdade;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }


}
