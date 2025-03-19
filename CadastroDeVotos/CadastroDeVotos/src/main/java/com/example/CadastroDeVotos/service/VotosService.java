package com.example.CadastroDeVotos.service;

import com.example.CadastroDeVotos.model.Funcionario;
import com.example.CadastroDeVotos.model.Restaurante;
import com.example.CadastroDeVotos.model.Votos;
import com.example.CadastroDeVotos.repository.FuncionarioRepository;
import com.example.CadastroDeVotos.repository.RestauranteRepository;
import com.example.CadastroDeVotos.repository.SistemaDeVotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotosService {


    @Autowired
    private SistemaDeVotosRepository sistemaDeVotosRepository;
    private RestauranteRepository restauranteRepository;
    private FuncionarioRepository funcionarioRepository;

    public void inserirVotoFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    public void inserirVotoRestaurante(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }

    public List<Votos> listaDeVotos() {
        return sistemaDeVotosRepository.findAll();

    }

    public Boolean verificaVoto(Integer id) {
        System.out.println(sistemaDeVotosRepository.findById(id) != null);
        return sistemaDeVotosRepository.findById(id) != null;
    }

    public void salvar(Votos dados) {
        Optional<Votos> opVoto = sistemaDeVotosRepository.findById(dados.getId());

        if(opVoto.isPresent()) {
            Votos editar = opVoto.get();
            editar.setFuncionario(dados.getFuncionario());
            editar.setRestaurante(dados.getRestaurante());
            editar.setData(dados.getData());
            sistemaDeVotosRepository.save(editar);
        }else {
            sistemaDeVotosRepository.save(dados);
        }
    }
    public Votos findById(Integer id) {
        return sistemaDeVotosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não encontrado!"));
    }

    
}