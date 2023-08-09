package br.com.questao2.dados;

import br.com.questao2.negocio.beans.beans.Consumidor;
import br.com.questao2.negocio.beans.beans.ReproducaoMidia;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IRepositorioReproducaoMidia {
    void cadastrarReproducaoMidia(ReproducaoMidia repmidia);
    ArrayList<ReproducaoMidia> listarReproducoesPorUsuario(Consumidor consumidor);
    ArrayList<ReproducaoMidia> listarReproducoesPorCategoria(ArrayList<String> categoria );
    ArrayList<ReproducaoMidia> listaReproducoesNoPeriodo(LocalDateTime inicio, LocalDateTime fim);
}
