package br.com.questao2.dados;

import br.com.questao2.negocio.beans.beans.Usuario;

import java.util.ArrayList;

public interface IRepositorioUsuario {
    boolean cadastrarUsuario(Usuario usuario);
    public ArrayList<Usuario> getUsuarios();
    boolean removerUsuario(Usuario usuario);
    ArrayList<Usuario> usuariosMaioresQue(int idade);
    ArrayList<Usuario> usuariosdaClasse(Class<?> classe);
    String toString();
}
