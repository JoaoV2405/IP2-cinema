package com.example.cineurubufinal.dados;

import com.example.cineurubufinal.exception.FilmeExisteException;
import com.example.cineurubufinal.negocio.beans.Filme;

import java.util.ArrayList;

public interface IRepositorioFilme {
    public boolean cadastrarFilme(Filme filme)throws FilmeExisteException;
    public boolean removerFilme(Filme filme);
    public ArrayList<Filme> getFilmes();
    public boolean checarNulo(Filme filme);
}
