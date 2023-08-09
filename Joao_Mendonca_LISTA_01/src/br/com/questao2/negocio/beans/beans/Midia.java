package br.com.questao2.negocio.beans.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Midia {
    private LocalDateTime dataHoraUpload;
    private String arquivo;
    private  int faixaEtariaMinima;
    private String categoria;
    private Produtor produtor;

    public Midia(LocalDateTime dataHoraUpload, String arquivo, int faixaEtariaMinima, String categoria, Produtor produtor) {
        this.dataHoraUpload = dataHoraUpload;
        this.arquivo = arquivo;
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.categoria = categoria;
        this.produtor = produtor;
    }

    public LocalDateTime getDataHoraUpload() {
        return dataHoraUpload;
    }

    public void setDataHoraUpload(LocalDateTime dataHoraUpload) {
        this.dataHoraUpload = dataHoraUpload;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public int getFaixaEtariaMinima() {
        return faixaEtariaMinima;
    }

    public void setFaixaEtariaMinima(int faixaEtariaMinima) {
        this.faixaEtariaMinima = faixaEtariaMinima;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Midia midia = (Midia) o;

        if (getFaixaEtariaMinima() != midia.getFaixaEtariaMinima()) return false;
        if (!getDataHoraUpload().equals(midia.getDataHoraUpload())) return false;
        if (!getArquivo().equals(midia.getArquivo())) return false;
        if (!getCategoria().equals(midia.getCategoria())) return false;
        return getProdutor().equals(midia.getProdutor());
    }

    @Override
    public int hashCode() {
        int result = getDataHoraUpload().hashCode();
        result = 31 * result + getArquivo().hashCode();
        result = 31 * result + getFaixaEtariaMinima();
        result = 31 * result + getCategoria().hashCode();
        result = 31 * result + getProdutor().hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Midia{" +
                "dataHoraUpload=" + dataHoraUpload + " / "+
            "arquivo=" + arquivo + " / "+
                "faixaEtariaMinima=" + faixaEtariaMinima +" / "+
                "categoria=" + categoria  +" / "+
                "produtor=" + produtor.getNomeCanal() +"}"+
                 "\n";
    }


    public static void main(String[] args) {
        Produtor prod1 = new Produtor ("luba@gmail.com", "Lucas Rossi", LocalDate.of(2004,5,6),"LubaTV");
        Midia midia = new Midia((LocalDateTime.of(2023,1,1,4,0)), "Phasmofobia gameplay",16, "Gameplay",prod1 );
        System.out.println(midia);
    }
}
