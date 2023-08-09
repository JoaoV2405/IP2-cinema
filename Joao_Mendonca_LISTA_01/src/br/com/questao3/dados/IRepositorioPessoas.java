package br.com.questao3.dados;
import br.com.questao3.negocio.beans.beans.Palestrante;
import br.com.questao3.negocio.beans.beans.Participante;
import br.com.questao3.negocio.beans.beans.Pessoa;

import java.util.ArrayList;

public interface IRepositorioPessoas {
    public ArrayList<Pessoa> getPessoas();
    void inserirPessoa(Pessoa pessoa);
    void removerPessoa(String email);
    Pessoa buscarPessoaPorEmail (String email);
    ArrayList<Palestrante> listarPalestrantesPorEmpresa (String empresa);
    ArrayList<Participante> listarParticipantesComInteresseEm(String trilha);
    ArrayList<Participante> listarParticipantesComIdadeMairQue(int idade);
}
