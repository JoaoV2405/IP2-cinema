package br.com.questao2.dados;

import br.com.questao2.negocio.beans.beans.Usuario;
import br.com.questao2.negocio.beans.beans.Produtor;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioUsuario implements IRepositorioUsuario {
    private ArrayList<Usuario> usuarios;
    private static RepositorioUsuario instanceU;
    private RepositorioUsuario(){
        this.usuarios = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public static RepositorioUsuario getInstanceU() {
        if (instanceU == null){
            instanceU = new RepositorioUsuario();
        }
        return instanceU;
    }

    /*cadastra o usuario*/
    public boolean cadastrarUsuario(Usuario usuario) {
        boolean resultado = false;
        if (usuario != null) {
            String email = usuario.getEmail();
            boolean usuarioIgual = false;
            for (Usuario novo : usuarios) {
                if (novo.getEmail().equals(email)) {
                    usuarioIgual = true;
                    break;
                }
            }
            if (!usuarioIgual) {
                this.usuarios.add(usuario);
                resultado = true;
            }
        }
        return resultado;
    }
    public boolean removerUsuario(Usuario usuario) {
        boolean usuarioExiste = false;
        String email = usuario.getEmail();
        String nome = usuario.getNomeCompleto();
        LocalDate dataDeNascimento = usuario.getDataNascimento();
        int i;
        for (i = 0; i < this.usuarios.size() && !usuarioExiste; i++) {
            Usuario usuario1 = this.usuarios.get(i);
            if (usuario1.getNomeCompleto().equals(nome) && usuario1.getEmail().equals(email) && usuario1.getDataNascimento().equals(dataDeNascimento) ) {
                usuarioExiste = true;
            }
        }
        if (usuarioExiste) {
            this.usuarios.remove(i-1);
        }
        return usuarioExiste;
    }
    public ArrayList<Usuario> usuariosMaioresQue(int idade){
        ArrayList<Usuario> usuarioMaior = new ArrayList<>();
        /*pega o ano atual*/
        int dataagr = LocalDate.now().getYear();
        for(Usuario u : this.usuarios){
             int age = dataagr - u.ano();
            if(idade > age){
                usuarioMaior.add(u);
            }
        }
        return usuarioMaior;
    }
    public ArrayList<Usuario> usuariosdaClasse(Class<?> classe){
        ArrayList<Usuario> usuariosClasse = new ArrayList<>();
        for(Usuario u : this.usuarios){
            if(classe.isInstance(u)){
                usuariosClasse.add(u);
            }
        }
        System.out.println("Usuarios da classe: ");
        for(int i=0; i< usuariosClasse.size();i++){
            System.out.println("-" + usuariosClasse.get(i).getNomeCompleto() + "\n");
        }
        return usuariosClasse;
    }

    @Override
    public String toString() {
        return "RepositorioUsuario{" +
                "usuarios=" + usuarios
                ;
    }
}
