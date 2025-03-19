package com.example.CadastroDeVotos.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "VOTOS")
public class Votos {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "label_sequence")
    @SequenceGenerator(name = "label_sequence", sequenceName = "label_sequence", allocationSize = 100)
    private Integer id;


    @Column(name = "DATA")
    private Calendar data;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    public Votos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votos votos = (Votos) o;
        return Objects.equals(id, votos.id) && Objects.equals(data, votos.data) && Objects.equals(funcionario, votos.funcionario) && Objects.equals(restaurante, votos.restaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, funcionario, restaurante);
    }

    @Override
    public String toString() {
        return "Votos{" +
                "id=" + id +
                ", data=" + data +
                ", funcionario=" + funcionario +
                ", restaurante=" + restaurante +
                '}';
    }
}
