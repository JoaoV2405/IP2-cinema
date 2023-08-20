package br.com.dados;
import br.com.negocio.beans.Filme;
import br.com.exception.FilmeExisteException;

import java.util.ArrayList;

public interface IRepositorioFilme {
    public boolean cadastrarFilme(Filme filme)throws FilmeExisteException;
    public boolean removerFilme(Filme filme);
    public ArrayList<Filme> getFilmes();
    public boolean checarNulo(Filme filme);
}
