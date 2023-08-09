package br.com.questao2.dados;

import br.com.questao2.negocio.beans.beans.Consumidor;
import br.com.questao2.negocio.beans.beans.ReproducaoMidia;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RepositorioReproducaoMidia implements IRepositorioReproducaoMidia {
    private ArrayList<ReproducaoMidia> repmidias;
    private static RepositorioReproducaoMidia instanceRP;

    public static RepositorioReproducaoMidia getInstanceRP() {
        if(instanceRP == null){
            instanceRP = new RepositorioReproducaoMidia();
        }
        return instanceRP;
    }

    private RepositorioReproducaoMidia(){
        this.repmidias = new ArrayList<>();
    }

    public void cadastrarReproducaoMidia(ReproducaoMidia repmidia) {
        if (repmidia != null) {
            this.repmidias.add(repmidia);
        }
    }

   public ArrayList<ReproducaoMidia> listaReproducoesNoPeriodo(LocalDateTime inicio, LocalDateTime fim){
        ArrayList<ReproducaoMidia> repPeriodo = new ArrayList<>();
        for(ReproducaoMidia rp : repmidias){
            if ( (rp.getDataHoraReproducao().isAfter(inicio) && rp.getDataHoraReproducao().isBefore(fim) ) ||
                    (rp.getDataHoraReproducao().compareTo(inicio) == 0 || rp.getDataHoraReproducao().compareTo(fim) == 0) )
            {
                repPeriodo.add(rp);
            }
        }
       System.out.println("Reproduções no período: ");
       for(int i=0; i< repPeriodo.size();i++){
           System.out.println("-" + repPeriodo.get(i).getMidia().getArquivo() + " por "+  repPeriodo.get(i).getConsumidor().getNomeCompleto() +"\n");
       }
        return repPeriodo;
    }

    public ArrayList<ReproducaoMidia> listarReproducoesPorUsuario(Consumidor consumidor){
        ArrayList<ReproducaoMidia> repusuario = new ArrayList<>();
        for(ReproducaoMidia ru : repmidias){
            if(ru.getConsumidor().equals(consumidor)){
                repusuario.add(ru);
            }
        }
        System.out.println("Reproduções por usuário: ");
        for(int i=0; i< repusuario.size();i++){
            System.out.println("-" + repusuario.get(i).getMidia().getArquivo() + "\n");
        }
        return repusuario;
    }
    public ArrayList<ReproducaoMidia> listarReproducoesPorCategoria(ArrayList<String> categoria){
        ArrayList<ReproducaoMidia> repcategoria = new ArrayList<>();
        for (String c : categoria){
            for(ReproducaoMidia rc : repmidias){
                if(c.equals(rc.getMidia().getCategoria())){
                    repcategoria.add(rc);
                }
            }
        }

        System.out.println("Reproduções por categoria: ");
        for(int i=0; i< repcategoria.size();i++){
            System.out.println("-" + repcategoria.get(i).getMidia() + "\n");
        }
        return repcategoria;
    }


    @Override
    public String toString() {
        return "RepositorioReproducaoMidia{" +
                "repmidias=" + repmidias;
    }
}
