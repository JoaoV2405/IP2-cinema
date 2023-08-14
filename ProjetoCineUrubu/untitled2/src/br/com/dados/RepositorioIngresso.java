package br.com.dados;
import br.com.beans.Ingresso;


import java.util.ArrayList;
import java.util.List;

public class RepositorioIngresso {
    
    private List<Ingresso> ingressos;

    public RepositorioIngresso(){
        ingressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    public List<Ingresso> listarIngressos(){
        return new ArrayList<>(ingressos); //--RETORNA UMA CÓPIA DA LISTA PARA EVITAR MOFICAÇÕES
    }

    //---BUSCA PELO INGRESSO DESEJADO
    public Ingresso buscarIngressoPorNumero(int numero){    //----OPCIONAL
        for (Ingresso ingresso : ingressos){
            if(ingresso.getId() == numero){
                return ingresso;
            }
        }

        return null; //---RETORNA NULL SE O INGRESSO NAO FOR ENCONTRADO
    }


    //---ATUALIZA O PRECO DO INGRESO
    public void atualizarPreco(int numero, double novoPreco){
        for (Ingresso ingresso : ingressos){
            if(ingresso.getId() == numero){
                ingresso.setPreco(novoPreco);
                return; //--SAI DO METODO APOS ATUALIZAR O PREÇO
            }
        }
        //----MANDA A FAMOSA EXCEÇÃO/IMPRIME UMA MENSAGEM SE O INGRESSO NÃO FOR ENCONTRADO
        throw new IllegalArgumentException("O Ingresso: " + numero + "não foi encontrado.");
    }

    //----REMOVE O INGRESSO
    public void removerIngresso(int numero){
        Ingresso ingressoRemover = null;
        for(Ingresso ingresso : ingressos){
            if(ingresso.getId() == numero){
                ingressoRemover = ingresso;
                break;
            }
        }

        if(ingressoRemover != null){
            ingressos.remove(ingressoRemover);
        }
        else{
            //----MANDA A FAMOSA EXCEÇÃO/IMPRIME UMA MENSAGEM SE O INGRESSO NÃO FOR ENCONTRADO
            throw new IllegalArgumentException("O Ingresso: " + numero + "não foi encontrado.");
        }
    }
}
