package com.example.cineurubufinal.dados;

import com.example.cineurubufinal.negocio.beans.Usuario;
import com.example.cineurubufinal.exception.UsuarioExisteException;

import java.util.ArrayList;

public interface IRepositorioUsuario {
    public ArrayList<Usuario> getUsuarios();
    public boolean removerUsuario(Usuario usuario);
    public boolean cadastrarUsuario(Usuario usuario)throws UsuarioExisteException;
}
