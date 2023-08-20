package br.com.negocio;

import br.com.dados.*;
import br.com.exception.UsuarioExisteException;
import br.com.negocio.beans.Usuario;

import java.util.ArrayList;

public class ControladorUsuario {
    private IRepositorioUsuario repositorioUsuario;
    private static ControladorUsuario instance;

    private ControladorUsuario() {
        this.repositorioUsuario = RepositorioUsuario.getInstance();
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }

        return instance;
    }

    public void cadastrarUsuario(Usuario usuario) throws UsuarioExisteException {
        if (usuario != null) {
                this.repositorioUsuario.cadastrarUsuario(usuario);
        }
    }
    public void removerUsuario(Usuario usuario) {
        if(usuario != null) this.repositorioUsuario.removerUsuario(usuario);
    }
    public ArrayList<Usuario> getUsuarios() {
        return this.repositorioUsuario.getUsuarios();
    }
}

