package br.com.questao2.negocio.beans.beans;

import br.com.questao2.dados.RepositorioMidia;

import java.time.LocalDateTime;

public class ReproducaoMidia {
    private Midia midia;
    private Consumidor consumidor;
    private LocalDateTime dataHoraReproducao;
    private static RepositorioMidia instanceRP;

    public ReproducaoMidia(Midia midia, Consumidor consumidor, LocalDateTime dataHoraReproducao) {
        this.midia = midia;
        this.consumidor = consumidor;
        this.dataHoraReproducao = dataHoraReproducao;
    }

    public static RepositorioMidia getInstanceRP() {
        return instanceRP;
    }

    public Midia getMidia() {
        return midia;
    }


    public Consumidor getConsumidor() {
        return consumidor;
    }

    public LocalDateTime getDataHoraReproducao() {
        return dataHoraReproducao;
    }


    @Override
    public String toString() {
        return "ReproducaoMidia{" +
                "midia=" + midia + "\n" +
                "consumidor=" + consumidor + "\n" +
                "dataHoraReproducao=" + dataHoraReproducao +
                '}'+ "\n";
    }
}
