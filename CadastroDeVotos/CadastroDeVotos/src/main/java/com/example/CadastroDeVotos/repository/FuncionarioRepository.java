package com.example.CadastroDeVotos.repository;

import com.example.CadastroDeVotos.model.Funcionario;
import com.example.CadastroDeVotos.model.Votos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
