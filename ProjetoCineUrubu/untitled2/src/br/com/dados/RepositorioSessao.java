package br.com.dados;

import br.com.negocio.beans.Sessao;
import br.com.exception.SessaoOcupadaException;

import java.util.ArrayList;

public class RepositorioSessao implements IRepositorioSessao{
    private ArrayList<Sessao> sessoes;
    private RepositorioSessao(){
        this.sessoes = new ArrayList<>();
    }
    private static RepositorioSessao instance;
    public static RepositorioSessao getInstance() {
        if (instance == null){
            instance = new RepositorioSessao();
        }
        return instance;
    }
    @Override
    public void cadastrarSessao(Sessao sessao) throws SessaoOcupadaException {
        boolean sessaoExiste = false;
        if (!checarNulo(sessao)) {
            for (Sessao sessao1 : this.sessoes) {
                if (sessao1.getId()==sessao.getId() && sessao1.getDataHora().equals(sessao.getDataHora())) {
                    sessaoExiste = true;
                    break;
                }
            }
        }

        if (!sessaoExiste) {
            this.sessoes.add(sessao);
        } else {
            throw new SessaoOcupadaException(sessao.getFilme().getTitulo(), sessao.getId());
        }
    }

    @Override
    public boolean removerSessao(Sessao sessao) {
        boolean sessaoExiste = false;
        String titulo = sessao.getFilme().getTitulo();
        int i;
        for (i = 0; i < this.sessoes.size() && !sessaoExiste; i++) {
            Sessao sessao1 = this.sessoes.get(i);
            if (sessao1.getId()==sessao.getId() && sessao1.getFilme().equals(sessao.getFilme())) {
                sessaoExiste = true;
            }
        }
        if (sessaoExiste) {
            this.sessoes.remove(i-1);
        }
        return sessaoExiste;
    }

    @Override
    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    @Override
    public boolean checarNulo(Sessao sessao) {
        if (sessao.getFilme() == null || sessao.getDataHora() == null|| sessao.getId() == 0) return true;
        else return false;
    }

}
