package br.com.questao3;

import br.com.questao3.negocio.beans.ControladorRECnPlay;
import br.com.questao3.negocio.beans.beans.Avaliacao;
import br.com.questao3.negocio.beans.beans.Palestra;
import br.com.questao3.negocio.beans.beans.Palestrante;
import br.com.questao3.negocio.beans.beans.Participante;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TesteQuestao3 {
    public static void main(String[] args) {
        ControladorRECnPlay controlador = ControladorRECnPlay.getInstance();
        /*PALESTRANTES*/
        Palestrante p1 = new Palestrante(1111, "gustavo@gmail.com", "Gustavo Franco", LocalDate.of(2000,2,2),"Recife", "Empresa X");
        Palestrante p2= new Palestrante(2222, "simone@gmail.com", "Simone Zelaquett", LocalDate.of(2000,2,2),"Recife", "Accenture");
        Palestrante p3 = new Palestrante(3333, "andrea@gmail.com", "Andrea Pinho", LocalDate.of(2000,2,2),"Recife", "Prefeitura do Recife");
        Palestrante p4 = new Palestrante(4444, "mariana@gmail.com", "Mariana Moura", LocalDate.of(2000,2,2),"Recife", "Grupo Moura");
        Palestrante p5 = new Palestrante(5555, "silvio@gmail.com", "Silvio Meira", LocalDate.of(2000,2,2),"Recife", "UFPE");

        /*
        *
        * PALESTRAS*/
        Palestra palestra1 = new Palestra(11111, "A inovação financeira e o sistema financeiro do futuro", p1, "Palestra sobre como as inovações tecnológicas financeiras podem influenciar o sistema financeiro",LocalDateTime.of(2023,2,10, 10,0),"Teatro Apolo","TECNOLOGIA");
        Palestra palestra2 = new Palestra(22222, "Apresentação do Humanóide NAO", p2, "Nessa atividade os participantes assistirão a performance do NAO- humanóide programado por estudantes da rede municipal do Recife, am\n" +
                "apresentações de Yoga e Dança que serão contagiantes e motivarão a interação dos presentes.",LocalDateTime.of(2023,2,10, 11,15),"Accenture Innovation Center","TECNOLOGIA");
        Palestra palestra3 = new Palestra(33333, "Imprensa Mirim", p3, "Durante o evento os palestrantes serão entrevistados como pauta da Cobertura jornalística das ações do Rec&#39;n&#39;Play , realizadas por\n" +
                "estudantes da Prefeitura de Recife. Muitos participantes poderão compor com os palestrantes as entrevistas prestando depoimentos sobre o\n" +
                "evento e suas impressões e novas aprendizagens.",LocalDateTime.of(2023,2,10, 10,0),"Teatro Apolo","TECNOLOGIA");
        Palestra palestra4 = new Palestra(44444, "Educação experimental para famílias empresárias", p4, "Uma conversa com os sócios e membros da Escola F para debater um novo modelo educacional voltado para famílias empresárias. Um modelo de\n" +
                "negócio colaborativo que valoriza a aprendizagem a partir da troca de experiências, investe na facilitação de grupos para gerar conhecimento e\n" +
                "desenvolvimento, por meio da construção de entendimentos e não apenas a partir de conteúdos externos.",LocalDateTime.of(2023,10,4, 10,0),"CESAR Bom Jesus - Sala Garagem (5º andar)","TECNOLOGIA");
        Palestra palestra5 = new Palestra(55555, "Como você e a sua empresa irão sobreviver ao apocalipse digital?", p5, "Talk Show com o renomado líder do setor de inovação que conversá sobre o tema de transformação digital.",LocalDateTime.of(2023,5,1, 10,0),"Cais do Sertão - Auditório","TECNOLOGIA");
        /*
        * CADASTRAR PALESTRAS
        * */
        controlador.cadastrarPalestra(palestra1);
        controlador.cadastrarPalestra(palestra2);
        controlador.cadastrarPalestra(palestra3);
        controlador.cadastrarPalestra(palestra4);
        controlador.cadastrarPalestra(palestra5);
        /*
        * RECADASTRAR PALESTRA ALTERADA
        * */
        Palestra palestra6 = new Palestra(33333, "Imprensa Mirim", p3, "Durante o evento os palestrantes serão entrevistados como pauta da Cobertura jornalística das ações do Rec&#39;n&#39;Play , realizadas por\n" +
                "estudantes da Prefeitura de Recife. Muitos participantes poderão compor com os palestrantes as entrevistas prestando depoimentos sobre o\n" +
                "evento e suas impressões e novas aprendizagens.", LocalDateTime.of(2023, 9, 5, 10, 0), "UFPE","TECNOLOGIA");
        controlador.cadastrarPalestra(palestra6);
        /*
        *PARTICIPANTES
        * */
        Participante participante1 = new Participante(1,"ALCIONE@gmail.com", "Alcione", LocalDate.of(2000,11,1),"Paulista", "TECNOLOGIA");
        Participante participante2 = new Participante(2,"PERICLES@gmail.com", "Pericles", LocalDate.of(1980,1,2),"Recife", "CIDADES");
        Participante participante3 = new Participante(3,"OLIVER@gmail.com", "Oliver", LocalDate.of(1950,2,3),"Jaboatao", "CIDADES");
        Participante participante4 = new Participante(4,"ALEX@gmail.com", "Alex", LocalDate.of(2000,2,4),"Boston", "TECNOLOGIA");
        Participante participante5 = new Participante(5,"CARTOLA@gmail.com", "Cartola", LocalDate.of(2003,3,6),"Shibuiya", "ECONOMIA_CRIATIVA");
        Participante participante6 = new Participante(6,"VANESSA@gmail.com", "Vanessa", LocalDate.of(2006,4,7),"Paulista", "TECNOLOGIA");
        Participante participante7 = new Participante(7,"CLARA@gmail.com", "Clara", LocalDate.of(1960,6,9),"Recife", "ECONOMIA_CRIATIVA");
        Participante participante8 = new Participante(8,"PEDRO@gmail.com", "Pedro", LocalDate.of(2000,3,12),"Olinda", "ECONOMIA_CRIATIVA");
        controlador.realizarInscricao(participante1);
        controlador.realizarInscricao(participante2);
        controlador.realizarInscricao(participante3);
        controlador.realizarInscricao(participante4);
        controlador.realizarInscricao(participante5);
        controlador.realizarInscricao(participante6);
        controlador.realizarInscricao(participante7);
        controlador.realizarInscricao(participante8);

        /*
        * LISTAR PARTICIPANTES COM MAIS DE 39 ANOS
        * */
        controlador.listarParticipantesComIdadeMairQue(39);

        /*
        *AVALIACOES PALESTRA 1
        * */
        Avaliacao avaliacao = new Avaliacao(palestra1, "BOA", participante1,4);
        Avaliacao avaliacao2 = new Avaliacao(palestra1, "UM LIXO", participante3,1);
        Avaliacao avaliacao3 = new Avaliacao(palestra1, "DEVERIA TER FICADO EM CASA", participante2,2);
        controlador.avaliarPalestra(avaliacao);
        controlador.avaliarPalestra(avaliacao2);
        controlador.avaliarPalestra(avaliacao3);
        /*System.out.println(palestra1.getMedia());*/
        /*
         *AVALIACOES PALESTRA 2
         * */
        Avaliacao P2avaliacao = new Avaliacao(palestra2, "BOA", participante1,5);
        Avaliacao P2avaliacao2 = new Avaliacao(palestra2, "INCRIVEL", participante3,5);
        Avaliacao P2avaliacao3 = new Avaliacao(palestra2, "ESPETACULAR", participante2,5);
        controlador.avaliarPalestra(P2avaliacao);
        controlador.avaliarPalestra(P2avaliacao2);
        controlador.avaliarPalestra(P2avaliacao3);
        /*System.out.println(palestra2.getMedia());*/
        /*
         *AVALIACOES PALESTRA 3
         * */
        Avaliacao P3avaliacao = new Avaliacao(palestra6, "BOA", participante1,5);
        Avaliacao P3avaliacao2 = new Avaliacao(palestra6, "MEH", participante3,3);
        Avaliacao P3avaliacao3 = new Avaliacao(palestra6, "ESPETACULAR", participante2,5);
        controlador.avaliarPalestra(P3avaliacao);
        controlador.avaliarPalestra(P3avaliacao2);
        controlador.avaliarPalestra(P3avaliacao3);
        /*System.out.println(palestra3.getMedia());*/
        /*
         *AVALIACOES PALESTRA 4
         * */
        Avaliacao P4avaliacao = new Avaliacao(palestra4, "LIXO", participante1,1);
        Avaliacao P4avaliacao2 = new Avaliacao(palestra4, "PODRE", participante3,1);
        Avaliacao P4avaliacao3 = new Avaliacao(palestra4, "NOJO", participante2,1);
        controlador.avaliarPalestra(P4avaliacao);
        controlador.avaliarPalestra(P4avaliacao2);
        controlador.avaliarPalestra(P4avaliacao3);
        /*System.out.println(palestra4.getMedia());*/
        /*
         *AVALIACOES PALESTRA 5
         * */
        Avaliacao P5avaliacao = new Avaliacao(palestra5, "BOA", participante1,5);
        Avaliacao P5avaliacao2 = new Avaliacao(palestra5, "INCRIVEL", participante3,5);
        Avaliacao P5avaliacao3 = new Avaliacao(palestra5, "NOJO", participante2,5);
        controlador.avaliarPalestra(P5avaliacao);
        controlador.avaliarPalestra(P5avaliacao2);
        controlador.avaliarPalestra(P5avaliacao3);
        /*
        * CHECAR TOTAL DE PALESTRAS COM MEDIA MAIOR QUE 3
        * */
        System.out.println("Total de palestras com média maior que 3 é: " +controlador.listarTotalPalestrasComMediaAvaliacaoMaiorQue(3) );
        /*
         * CHECAR PALESTRAS MAIS BEM AVALIADAS
         * */
        controlador.listarPalestrasMaisBemAvaliadas();
    }
}

