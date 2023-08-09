package br.com.questao3.negocio.beans.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Comparator;
import static java.util.Comparator.comparing;
public class Palestra {
    private long id;
    private String titulo;
    private Palestrante palestrante;
    private String descricao;
    private ArrayList<Avaliacao> avaliacoes;
    private LocalDateTime dataHora;
    private String local;
    private String trilha;
    private int media;
    public Palestra(String titulo) {
        this.titulo = titulo;

    }

    public Palestra(long id, String titulo, Palestrante palestrante, String descricao, LocalDateTime dataHora, String local, String trilha) {
        this.id = id;
        this.titulo = titulo;
        this.palestrante = palestrante;
        this.descricao = descricao;
        this.avaliacoes = new ArrayList<>();
        this.dataHora = dataHora;
        setTrilha(trilha);
        this.trilha = getTrilha();
        this.local = local;
        setMedia();
        this.media = getMedia();
    }

    public int getMedia() {
        return media;
    }

    public void setMedia() {
        if(avaliacoes.size()>0) {
            int nota = 0;
            int i = 0;
            for (i = 0; i < avaliacoes.size(); i++) {
                Avaliacao avaliacao = this.avaliacoes.get(i);
                nota += avaliacao.getNota();
            }
            this.media = (nota / i);
        }
    }
    public void addAvaliacoes(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public void setTrilha(String trilha) {
        switch (trilha){
            case "TECNOLOGIA", "CIDADES", "ECONOMIA_CRIATIVA":
                this.trilha = trilha;
                break;
            default: throw new RuntimeException("Trilha inválida");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTrilha() {
        return trilha;
    }

    @Override
    public String toString() {
        return "Palestra{" +
                "id: " + id +
                ", titulo: " + titulo + '\'' +
                ", palestrante: " + palestrante.getNome() +
                ", descricao: " + descricao + '\'' +
                ", avaliacoes: " + avaliacoes +
                ", dataHora: " + dataHora +
                ", local: " + local + '\'' +
                ", trilha: " + trilha + '\'' +
                '}'  ;
    }


}
