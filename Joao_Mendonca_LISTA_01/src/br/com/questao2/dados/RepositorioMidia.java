package br.com.questao2.dados;

import br.com.questao2.negocio.beans.beans.Midia;

import java.util.ArrayList;

public class RepositorioMidia implements IRepositorioMidia{
    private ArrayList<Midia> midias;
    private static RepositorioMidia instance;

    private RepositorioMidia(){
        this.midias = new ArrayList<>();
    }
    /*METODO CADASTRAR MIDIA*/
    public boolean cadastrarMidia(Midia midia) {
        boolean resultado = false;
        if (midia != null) {
            String arquivo = midia.getArquivo();
            boolean arquivoIgual = false;
            for (Midia m : midias) {
                if ( m.getArquivo().equals(arquivo)) {
                    arquivoIgual = true;
                    break;
                }
            }
            if (!arquivoIgual) {
                this.midias.add(midia);
                resultado = true;
            }
        }
        return resultado;
    }
    /*METODO REMOVER MIDIA*/
    public boolean removerMidia(Midia midia) {
        boolean usuarioExiste = false;
        int i;
        for (i = 0; i < this.midias.size() && !usuarioExiste; i++) {
            Midia midia1 = this.midias.get(i);
            if (midia.equals(midia1)) {
                usuarioExiste = true;
            }
        }
        if (usuarioExiste) {
            this.midias.remove(i-1);
        }
        return usuarioExiste;
    }
    public ArrayList<Midia>listarMidiasPorFaixaEtaria(int faixaEtariaMinima){
        ArrayList<Midia> MidiaFaixaEtaria = new ArrayList<>();
        for(Midia midia : this.midias){
            if(faixaEtariaMinima <= midia.getFaixaEtariaMinima()){
                MidiaFaixaEtaria.add(midia);
            }
        }
        for (Midia midia : MidiaFaixaEtaria) {
            System.out.println("-" + midia.getArquivo() + "\n");
        }
        return MidiaFaixaEtaria ;
    }

    public ArrayList<Midia>listarReproducoesPorCategorias(String categoria){
        ArrayList<Midia> categoriaAux = new ArrayList<>();
        for(Midia m: midias){
            String categoriaMidia = m.getCategoria();
            if(categoriaMidia.equals(categoria)) {
                categoriaAux.add(m);
            }

        }
        for(int i=0; i< categoriaAux.size();i++){
            System.out.println("-" + categoriaAux.get(i).getArquivo() + "\n");
        }
        return categoriaAux;
    }

    public ArrayList<Midia> getMidias() {
        return midias;
    }

    public void setMidias(ArrayList<Midia> midias) {
        this.midias = midias;
    }

    @Override
    public String toString() {
        return "\n" + "RepositorioMidia{" +
                "midias=" + midias
                ;
    }

    public static RepositorioMidia getInstance() {
        if (instance == null){
            instance = new RepositorioMidia();
        }
        return instance;
    }
}
