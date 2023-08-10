package br.com.dados;

import br.com.beans.Filme;
import br.com.exception.FilmeExisteException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class RepositorioFilme implements IRepositorioFilme{
    private ArrayList<Filme> filmes;
    private RepositorioFilme(){
        this.filmes = new ArrayList<>();
    }


    @Override
    public boolean cadastrarFilme(Filme filme) throws FilmeExisteException {
        boolean resultado = false;
        if(!checarNulo(filme)){
            String titulo = filme.getTitulo();
            boolean tituloIgual = false;
            for (Filme novo : filmes) {
                if (novo.getTitulo().equals(titulo)) {
                    tituloIgual = true;
                    break;
                }
            }
            if (!tituloIgual) {
                this.filmes.add(filme);
                resultado = true;
            }
            else{
                throw new FilmeExisteException(filme.getTitulo());
            }
        }
        return resultado;
    }


    @Override
    public boolean removerFilme(Filme filme) {
        boolean filmeExiste = false;
        String titulo = filme.getTitulo();
        int i;
        for (i = 0; i < this.filmes.size() && !filmeExiste; i++) {
            Filme filme1 = this.filmes.get(i);
            if (filme1.getTitulo().equals(titulo)) {
                filmeExiste = true;
            }
        }
        if (filmeExiste) {
            this.filmes.remove(i-1);
        }
        return filmeExiste;
    }

    @Override
    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    @Override
    public boolean checarNulo(Filme filme) {
        if (filme.getDuracao() == null || filme.getGenero() == null || filme.getTitulo() == null) return true;
        else return false;
    }

    public static void main(String[] args) throws FilmeExisteException {
        RepositorioFilme rep = new RepositorioFilme();
        Filme filme = new Filme("1", "terror", "ua", 4,LocalTime.of(3,5));
        Filme filme2 = new Filme("2", "comedia", "au", 4,LocalTime.of(3,5));
        rep.cadastrarFilme(filme);
        rep.cadastrarFilme(filme2);
        System.out.println(rep.getFilmes());
        rep.removerFilme(filme);
        System.out.println(rep.getFilmes());

    }
}
