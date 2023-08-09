package br.com.questao2;
import br.com.questao2.negocio.beans.ControladorMidia;
import br.com.questao2.negocio.beans.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Teste {
    public static void main(String[] args) {
        ControladorMidia controlador = ControladorMidia.getInstance();
        /*
        * CRIAR E CADASTRAR PRODUTORES
        * */
        Produtor prod1 = new Produtor ("luba@gmail.com", "Lucas Rossi", LocalDate.of(2004,5,6),"LubaTV");
        Produtor prod2 = new Produtor ("alex@gmail.com", "Alex Apollonov ", LocalDate.of(1990,5,6),"i did a thing");
        Produtor prod3 = new Produtor ("curt@gmail.com", "Curt Smith", LocalDate.of(2004,5,6),"Tears for Fears vevo");
        controlador.cadastrarUsuario(prod1);
        controlador.cadastrarUsuario(prod2);
        controlador.cadastrarUsuario(prod3);
        /*
        * CRIAR E CADASTRAR CONSUMIDORES
        * */
        Consumidor cons1 = new Consumidor("necoarc@gmail.com", "João Victor", LocalDate.of(2001,5,5));
        Consumidor cons2 = new Consumidor("paulinho123@gmail.com", "Paulo Matias", LocalDate.of(1940,6,10));
        Consumidor cons3 = new Consumidor("ucoringa@gmail.com", "Higor Mateus", LocalDate.of(2018,2,5));
        Consumidor cons4 = new Consumidor("chovechuva@gmail.com", "Jorge Ben Jor", LocalDate.of(1974,1,5));
        Consumidor cons5 = new Consumidor("raluca@gmail.com", "Julia de Souza", LocalDate.of(2002,5,5));
        Consumidor cons6 = new Consumidor("rogerinho@gmail.com", "Rogerio do Ingá", LocalDate.of(1987,5,9));
        Consumidor cons7 = new Consumidor("maurilio@gmail.com", "Maurilio dos Anjos", LocalDate.of(1995,10,1));
        controlador.cadastrarUsuario(cons1);
        controlador.cadastrarUsuario(cons2);
        controlador.cadastrarUsuario(cons3);
        controlador.cadastrarUsuario(cons4);
        controlador.cadastrarUsuario(cons5);
        controlador.cadastrarUsuario(cons6);
        controlador.cadastrarUsuario(cons7);
        /*
        * REMOVER ULTIMO CONSUMIDOR
        * */
        controlador.removerUsuario(cons7);
        /*
         * RECUPERAR LISTA DE USUARIOS DA CLASSE CONSUMIDOR
         * */
        controlador.usuariosdaClasse(Consumidor.class);
        /*
        * RECUPERAR LISTA DE USUARIOS MAIORES QUE 16 ANOS
        * */
        controlador.usuariosMaioresQue(16);
        /*
        * CADASTRAR MIDIAS
        * */
        Midia midia1 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Phasmofobia gameplay",16, "Gameplay",prod1 );
        Midia midia2 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Memes do reddit",0, "Comedia",prod1 );
        Midia midia3 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Dead by Daylight gameplay",18, "Terror",prod2 );
        Midia midia4 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Red Dead Redemptiom gameplay",18, "Gameplay",prod1 );
        Midia midia5 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Phyton tutorial",0, "Tutorial",prod2 );
        Midia midia6 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Scary Media vol.1",16, "Terror",prod3 );
        Midia midia7 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Como se comunicar fantasmas usando maizena e C++",18, "Tutorial",prod3 );
        Midia midia8 = new Midia(LocalDateTime.of(2023,1,1,4,0), "Stand up comedy",18, "Comedia",prod3 );
        controlador.cadastrarMidia(midia1);
        controlador.cadastrarMidia(midia2);
        controlador.cadastrarMidia(midia3);
        controlador.cadastrarMidia(midia4);
        controlador.cadastrarMidia(midia5);
        controlador.cadastrarMidia(midia6);
        controlador.cadastrarMidia(midia7);
        controlador.cadastrarMidia(midia8);
        /*REMOVER MIDIA*/
        controlador.removerMidia(midia8);
        /*
        * LISTAR MIDIAS COM FAIXA ETARIA MAIOR QUE 14
        * */
        System.out.println("Categorias por faixa etária: ");
        controlador.listarMidiasPorFaixaEtaria(14);
        /*
        * LISTAR MIDIAS DE CATEGORIA QUALQUER
        * */
        controlador.listarReproducoesPorCategorias("Comedia");
        /*
        * REPRODUZIR MIDIA
        * */
        controlador.ReproduzirMidia(cons1, midia1);
        controlador.ReproduzirMidia(cons1,midia3);
        controlador.ReproduzirMidia(cons1, midia2);
        controlador.ReproduzirMidia(cons1,midia7);
        controlador.ReproduzirMidia(cons2, midia4);
        controlador.ReproduzirMidia(cons2,midia3);
        controlador.ReproduzirMidia(cons2, midia5);
        controlador.ReproduzirMidia(cons2, midia6);
        controlador.ReproduzirMidia(cons3, midia2);
        controlador.ReproduzirMidia(cons3, midia5);
        controlador.ReproduzirMidia(cons4, midia1);
        controlador.ReproduzirMidia(cons4, midia3);
        controlador.ReproduzirMidia(cons4, midia4);
        controlador.ReproduzirMidia(cons4, midia6);
        controlador.ReproduzirMidia(cons5, midia2);
        controlador.ReproduzirMidia(cons5, midia1);
        controlador.ReproduzirMidia(cons5, midia4);
        controlador.ReproduzirMidia(cons6, midia1);
        controlador.ReproduzirMidia(cons6, midia2);
        controlador.ReproduzirMidia(cons6, midia4);
        /*
         * REPRODUCAO INVALIDA
         * */
        controlador.ReproduzirMidia(cons3, midia4);
        /*
        * REPRODUCOES NO PERIODO
        * */
        controlador.listaReproducoesNoPeriodo(LocalDateTime.of(2023,7,9,10,10), LocalDateTime.now());
        /*
        * REPRODUCOES POR USUARIO QUALQUER
        * */
        controlador.listarReproducoesPorUsuario(cons1);
        /*
        * REPRODUCOES POR CATEGORIA
        * */
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Terror");
        controlador.listarReproducoesPorCategoria(categorias);
    }
}
