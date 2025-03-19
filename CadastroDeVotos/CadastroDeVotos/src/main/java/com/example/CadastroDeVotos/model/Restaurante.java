package com.example.CadastroDeVotos.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Entity
@Table(name = "RESTAURANTE")
public class Restaurante{

@Id
@Column
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "label_sequence")
@SequenceGenerator(name = "label_sequence", sequenceName = "label_sequence", allocationSize = 100)
private Integer id;

@Column (name = "NomeRestaurante")
private String nomeRestaurante;

    public Restaurante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id=" + id +
                ", nome='" + nomeRestaurante + '\'' +
                '}';
    }
}
