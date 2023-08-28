package com.example.cineurubufinal.negocio;

import com.example.cineurubufinal.dados.*;
import com.example.cineurubufinal.exception.AssentoOcupadoException;
import com.example.cineurubufinal.exception.FilmeExisteException;
import com.example.cineurubufinal.negocio.beans.Filme;
import com.example.cineurubufinal.negocio.beans.Ingresso;

import java.util.ArrayList;
import java.util.List;

public class ControladorIngresso {

    private IRepositorioIngresso repositorioIngresso;
    private static ControladorIngresso instance;
    private ControladorIngresso() {
        this.repositorioIngresso = RepositorioIngresso.getInstance();
    }
    public static ControladorIngresso getInstance() {
        if (instance == null) {
            instance = new ControladorIngresso();
        }

        return instance;
    }

    public void adicionarIngresso(Ingresso ingresso) throws AssentoOcupadoException {
        if(ingresso!=null){
            this.repositorioIngresso.adicionarIngresso(ingresso);
        }
        else return;
    }

    public List<Ingresso> listarIngressos(){return this.repositorioIngresso.listarIngressos();}
    public Ingresso buscarIngressoPorNumero(int numero){return this.repositorioIngresso.buscarIngressoPorNumero(numero);}
    public void removerIngresso(int numero){this.repositorioIngresso.removerIngresso(numero);}


}