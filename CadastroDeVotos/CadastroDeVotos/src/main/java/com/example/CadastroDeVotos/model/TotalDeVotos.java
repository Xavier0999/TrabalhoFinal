package com.example.CadastroDeVotos.model;


public class TotalDeVotos {

private String nomeFuncionario;
private String nomeRestaurante;
private Long totalDeVotos;

    public TotalDeVotos(String nomeFuncionario, String nomeRestaurante, Long totalDeVotos) {
        this.nomeFuncionario = nomeFuncionario;
        this.nomeRestaurante = nomeRestaurante;
        this.totalDeVotos = totalDeVotos;
    }

    @Override
    public String toString() {
        return "TotalDeVotos{" +
                "nomeFuncionario='" + nomeFuncionario + '\'' +
                ", nomeRestaurante='" + nomeRestaurante + '\'' +
                ", totalDeVotos=" + totalDeVotos +
                '}';
    }
}
