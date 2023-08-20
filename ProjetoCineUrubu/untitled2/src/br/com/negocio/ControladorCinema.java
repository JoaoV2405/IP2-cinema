package br.com.negocio;

import br.com.dados.*;
import br.com.exception.AssentoOcupadoException;
import br.com.exception.FilmeExisteException;
import br.com.negocio.beans.Filme;
import br.com.negocio.beans.Ingresso;

import java.util.ArrayList;
import java.util.List;

public class ControladorCinema {
    private IRepositorioSessao repositorioSessao;
    private IRepositorioFilme repositorioFilme;
    private IRepositorioIngresso repositorioIngresso;
    private static ControladorCinema instance;
    private ControladorCinema() {
        this.repositorioSessao = RepositorioSessao.getInstance();
        this.repositorioFilme = RepositorioFilme.getInstance();
        this.repositorioIngresso = RepositorioIngresso.getInstance();
    }
    public static ControladorCinema getInstance() {
        if (instance == null) {
            instance = new ControladorCinema();
        }

        return instance;
    }
    public boolean cadastrarFilme(Filme filme) throws FilmeExisteException {
        if(!repositorioFilme.checarNulo(filme)) {
            return this.repositorioFilme.cadastrarFilme(filme);
        }
        else throw new FilmeExisteException(filme.getTitulo());
    }
    public boolean removerFilme(Filme filme) {
        if(!repositorioFilme.checarNulo(filme)){
            return this.repositorioFilme.removerFilme(filme);
        }
        return false;
    }
    public ArrayList<Filme> getFilmes() {
        return this.repositorioFilme.getFilmes();
    }
    public void adicionarIngresso(Ingresso ingresso) throws AssentoOcupadoException {
        if(ingresso!=null){
            this.repositorioIngresso.adicionarIngresso(ingresso);
        }
        else throw new AssentoOcupadoException();
    }
    public List<Ingresso> listarIngressos(){return this.repositorioIngresso.listarIngressos();}
    public Ingresso buscarIngressoPorNumero(int numero){return this.repositorioIngresso.buscarIngressoPorNumero(numero);}
    public void removerIngresso(int numero){this.repositorioIngresso.removerIngresso(numero);}


}
