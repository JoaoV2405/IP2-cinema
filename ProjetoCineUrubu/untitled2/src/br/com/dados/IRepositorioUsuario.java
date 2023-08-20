package br.com.dados;

import br.com.negocio.beans.Usuario;
import br.com.exception.UsuarioExisteException;

import java.util.ArrayList;

public interface IRepositorioUsuario {
    public ArrayList<Usuario> getUsuarios();
    public boolean removerUsuario(Usuario usuario);
    public boolean cadastrarUsuario(Usuario usuario)throws UsuarioExisteException;
}
