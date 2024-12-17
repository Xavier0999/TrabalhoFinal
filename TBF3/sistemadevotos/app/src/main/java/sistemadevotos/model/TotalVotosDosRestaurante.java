package main.java.sistemadevotos.model;

public class TotalVotosDosRestaurante {

    private String nomeRestaurante;
    private Long totalVotos;

    

    public TotalVotosDosRestaurante(String nomeRestaurante, Long totalVotos) {
        this.nomeRestaurante = nomeRestaurante;
        this.totalVotos = totalVotos;
    }



    @Override
    public String toString() {
        return "Total De Votos Dos Restaurante: " + nomeRestaurante + " Total De Votos: " + totalVotos ;
    }

}
