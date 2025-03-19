package com.example.CadastroDeVotos.repository;


import com.example.CadastroDeVotos.model.Votos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SistemaDeVotosRepository extends JpaRepository<Votos, Integer> {

    List<Votos> findByOrderByTotalDeVotosDesc();



}
