package br.com.questao2.dados;

import br.com.questao2.negocio.beans.beans.Midia;

import java.util.ArrayList;

public interface IRepositorioMidia {
    boolean cadastrarMidia(Midia midia);
    boolean removerMidia(Midia midia);
    ArrayList<Midia> listarMidiasPorFaixaEtaria(int faixaEtariaMinima);
    ArrayList<Midia>listarReproducoesPorCategorias(String categoria);
    ArrayList<Midia> getMidias();
    void setMidias(ArrayList<Midia> midias);
    String toString();
}
