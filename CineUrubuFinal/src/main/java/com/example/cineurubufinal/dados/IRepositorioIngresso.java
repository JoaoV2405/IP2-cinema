package com.example.cineurubufinal.dados;

import com.example.cineurubufinal.exception.AssentoOcupadoException;
import com.example.cineurubufinal.negocio.beans.Ingresso;

import java.util.List;

public interface IRepositorioIngresso {
    public void adicionarIngresso(Ingresso ingresso) throws AssentoOcupadoException;
    public List<Ingresso> listarIngressos();
    public Ingresso buscarIngressoPorNumero(int numero);
    public void atualizarPreco(int numero, double novoPreco) throws Exception;
    public void removerIngresso(int numero);


}
