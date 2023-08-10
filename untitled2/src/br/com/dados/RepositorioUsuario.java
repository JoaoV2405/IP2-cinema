package br.com.dados;

import br.com.beans.Sessao;
import br.com.beans.Usuario;
import br.com.exception.UsuarioExisteException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RepositorioUsuario implements IRepositorioUsuario{
    private ArrayList<Usuario> usuarios;
    private RepositorioUsuario(){
        this.usuarios = new ArrayList<>();
    }


    public boolean cadastrarUsuario(Usuario usuario)throws UsuarioExisteException {
        boolean resultado = false;
        if (usuario != null) {
            String email = usuario.getEmail();
            long cpf = usuario.getCpf();
            boolean usuarioIgual = false;
            for (Usuario novo : usuarios) {
                if (novo.getEmail().equals(email)||novo.getCpf()==cpf) {
                    usuarioIgual = true;
                    break;
                }
            }
            if (!usuarioIgual) {
                this.usuarios.add(usuario);
                resultado = true;
            }
            else{
                throw new UsuarioExisteException(usuario.getEmail(), usuario.getCpf());
            }
        }
        return resultado;
    }
    public boolean removerUsuario(Usuario usuario) {
        boolean usuarioExiste = false;
        String email = usuario.getEmail();
        String nome = usuario.getNome();
        LocalDateTime dataDeNascimento = usuario.getDataDeNascimento();
        int i;
        for (i = 0; i < this.usuarios.size() && !usuarioExiste; i++) {
            Usuario usuario1 = this.usuarios.get(i);
            if (usuario1.getNome().equals(nome) && usuario1.getEmail().equals(email) && usuario1.getDataDeNascimento().equals(dataDeNascimento) ) {
                usuarioExiste = true;
            }
        }
        if (usuarioExiste) {
            this.usuarios.remove(i-1);
        }

        return usuarioExiste;
    }
    @Override
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
