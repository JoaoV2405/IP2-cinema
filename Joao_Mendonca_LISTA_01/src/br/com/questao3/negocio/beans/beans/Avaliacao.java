package br.com.questao3.negocio.beans.beans;

public class Avaliacao {
    private Palestra palestra;
    private int nota;
    private String comentario;
    private Participante avaliador;

    public Avaliacao(Palestra palestra, String comentario, Participante avaliador, int nota) {
        setNota(nota);
        this.nota = getNota();
        this.comentario = comentario;
        this.avaliador = avaliador;
        this.palestra = palestra;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        switch (nota){
            case 0, 1, 2, 3,4, 5:
                this.nota = nota;
                break;
            default: throw new RuntimeException("Nota inválida");
        }

    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Participante getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Participante avaliador) {
        this.avaliador = avaliador;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +getPalestra().getTitulo()+
                " - nota: " + nota +
                ", comentario: " +'\''+ comentario + '\'' +
                ", avaliador: " + avaliador.getNome() +
                '}'+ "\n";
    }
}
