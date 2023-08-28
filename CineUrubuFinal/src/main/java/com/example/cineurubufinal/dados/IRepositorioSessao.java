package com.example.cineurubufinal.dados;

import com.example.cineurubufinal.negocio.beans.Sessao;
import com.example.cineurubufinal.exception.SessaoOcupadaException;

import java.util.ArrayList;

public interface IRepositorioSessao {
    public void cadastrarSessao(Sessao sessao)throws SessaoOcupadaException;
    public boolean removerSessao(Sessao sessao);
    public ArrayList<Sessao> getSessoes();
    public boolean checarNulo(Sessao sessao);
}
