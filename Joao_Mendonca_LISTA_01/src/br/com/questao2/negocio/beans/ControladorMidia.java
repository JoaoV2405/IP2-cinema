package br.com.questao2.negocio.beans;
import br.com.questao2.dados.*;
import br.com.questao2.negocio.beans.beans.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ControladorMidia {
    private IRepositorioReproducaoMidia repositorioRP;
    private IRepositorioMidia repositorioM;
    private IRepositorioUsuario repositorioU;
    private static ControladorMidia instance;
    private ControladorMidia() {
        this.repositorioM = RepositorioMidia.getInstance();
        this.repositorioU = RepositorioUsuario.getInstanceU();
        this.repositorioRP = RepositorioReproducaoMidia.getInstanceRP();
    }
    public static ControladorMidia getInstance() {
        if (instance == null) {
            instance = new ControladorMidia();
        }

        return instance;
    }

        public void cadastrarUsuario(Usuario usuario) {
            if(usuario != null){
                if(usuario instanceof Produtor){
                    if(((Produtor) usuario).getCategorias() == null){
                        throw new RuntimeException("Lista de categorias do produtor não pode ser nula");
                    }
                }else{this.repositorioU.cadastrarUsuario(usuario);}
            }
        }

    public ArrayList<Usuario> getUsuarios() {
        return this.repositorioU.getUsuarios();
    }
        public void removerUsuario(Usuario usuario) {
            if(usuario != null){
                this.repositorioU.removerUsuario(usuario);
            }
        }

        public void usuariosMaioresQue(int idade) {
            this.repositorioU.usuariosMaioresQue(idade);
        }

        public void usuariosdaClasse(Class<?> classe) {
            this.repositorioU.usuariosdaClasse(classe);
        }

    @Override
    public String toString() {
        return repositorioU.toString() + repositorioM.toString() + repositorioRP.toString();

    }

    public void cadastrarMidia(Midia midia) {
        if(midia != null){
            if(midia.getProdutor().getCategorias().contains(midia.getCategoria())){
                this.repositorioM.cadastrarMidia(midia);
            }
        }
    }

    public void removerMidia(Midia midia) {
        if(midia != null){
            repositorioM.removerMidia(midia);
        }
    }

    public ArrayList<Midia> listarMidiasPorFaixaEtaria(int faixaEtariaMinima) {
        return repositorioM.listarMidiasPorFaixaEtaria(faixaEtariaMinima);
    }
    public ArrayList<ReproducaoMidia> listaReproducoesNoPeriodo(LocalDateTime inicio, LocalDateTime fim){
        return repositorioRP.listaReproducoesNoPeriodo(inicio, fim);
    }
    public ArrayList<Midia> listarReproducoesPorCategorias(String categoria) {
        System.out.println("as midias sao: ");
        return repositorioM.listarReproducoesPorCategorias(categoria);
    }
    public String toString2(){
        return repositorioM.toString();
    }
    public void ReproduzirMidia(Consumidor consumidor, Midia midia){
        if(consumidor != null && midia != null && midia.getArquivo()!= null
                && consumidor.getEmail() != null){
            if(consumidor.ano() >= midia.getFaixaEtariaMinima()){
                ReproducaoMidia rp = new ReproducaoMidia(midia, consumidor, LocalDateTime.now());
                repositorioRP.cadastrarReproducaoMidia(rp);
            }
        }
    }

    public ArrayList<ReproducaoMidia> listarReproducoesPorCategoria(ArrayList<String> categoria) {
        return repositorioRP.listarReproducoesPorCategoria(categoria);
    }

    public ArrayList<ReproducaoMidia> listarReproducoesPorUsuario(Consumidor consumidor) {
        return repositorioRP.listarReproducoesPorUsuario(consumidor);
    }
}














