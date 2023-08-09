package br.com.questao3.dados;
import br.com.questao3.negocio.beans.beans.Avaliacao;
import br.com.questao3.negocio.beans.beans.Palestra;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IRepositorioPalestras {
    void inserirPalestra(Palestra p);
    Palestra buscarPalestraPorId(int id);
    ArrayList<Palestra>listarPalestras ();
    ArrayList<Palestra>listarPalestrasComMediaAvaliacaIgualOuMaiorQue(int nota);
    ArrayList<Avaliacao>listarTodasAvaliacoes ();
    public ArrayList<Palestra> getPalestras();
    Palestra buscarPalestrasPorLocalEHorario(String local, LocalDateTime horario);
}
