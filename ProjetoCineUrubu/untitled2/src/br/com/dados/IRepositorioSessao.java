package br.com.dados;

import br.com.negocio.beans.Sessao;
import br.com.exception.SessaoOcupadaException;

import java.util.ArrayList;

public interface IRepositorioSessao {
    public void cadastrarSessao(Sessao sessao)throws SessaoOcupadaException;
    public boolean removerSessao(Sessao sessao);
    public ArrayList<Sessao> getSessoes();
    public boolean checarNulo(Sessao sessao);
}
