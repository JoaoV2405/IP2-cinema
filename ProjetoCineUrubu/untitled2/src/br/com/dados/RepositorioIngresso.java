package br.com.dados;
import br.com.negocio.beans.Ingresso;
import br.com.negocio.beans.Sessao;
import br.com.exception.AssentoOcupadoException;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositorioIngresso implements IRepositorioIngresso {
    
    private List<Ingresso> ingressos;
    private static RepositorioIngresso instance;
    public static RepositorioIngresso getInstance() {
        if (instance == null){
            instance = new RepositorioIngresso();
        }
        return instance;
    }
    public RepositorioIngresso(){
        ingressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso) throws AssentoOcupadoException {
        if(ingresso!=null){
            Scanner scanner = new Scanner(System.in);
            String assento = scanner.next();
            int i;
            if(ingresso.getSessao().getAssentoOcupado()==null){
                ingresso.getSessao().setAssentoOcupado(assento);
            }
            else{
                for(i = 0; i<= ingresso.getSessao().getAssentoOcupado().size(); i++){
                    if(ingresso.getSessao().getAssentoOcupado().get(i).equals(assento)){
                        throw new AssentoOcupadoException();}
                    else{
                        ingresso.getSessao().setAssentoOcupado(assento);}
                }
            }


            System.out.println(ingresso.getSessao().getAssentoOcupado());
            ingresso.setAssento(assento);
            this.ingressos.add(ingresso);
        }


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
    public void atualizarPreco(int numero, double novoPreco) throws Exception {
        for (Ingresso ingresso : ingressos){
            if(ingresso.getId() == numero){
                ingresso.setPreco(novoPreco);
                return; //--SAI DO METODO APOS ATUALIZAR O PREÇO
            }
        }
        //----MANDA A FAMOSA EXCEÇÃO/IMPRIME UMA MENSAGEM SE O INGRESSO NÃO FOR ENCONTRADO
        throw new Exception("O Ingresso: " + numero + "não foi encontrado.");
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

    public static void main(String[] args) throws AssentoOcupadoException {
        RepositorioIngresso rep = new RepositorioIngresso();
        Sessao sessao = new Sessao();
        Ingresso ingresso = new Ingresso(sessao);
        Ingresso ingresso2 = new Ingresso(sessao);
        rep.adicionarIngresso(ingresso);
        rep.adicionarIngresso(ingresso2);

    }
}
