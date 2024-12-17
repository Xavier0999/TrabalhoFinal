package sistemadevotos.controller;

import java.util.List;

import br.org.fundatec.exception.AplicacaoException;
import main.java.sistemadevotos.exception.LimiteDeVotosDiariosException;
import main.java.sistemadevotos.model.TotalVotosDosRestaurante;
import main.java.sistemadevotos.model.Repository.FuncionarioRepository;
import main.java.sistemadevotos.model.Repository.RestauranteRepository;
import main.java.sistemadevotos.model.Repository.VotosRepository;

public class VotacaoController {

private FuncionarioRepository funcionarioRepository;
private RestauranteRepository restauranteRepository;
private VotosRepository votosRepository;


public VotacaoController(FuncionarioRepository funcionarioRepository, RestauranteRepository restauranteRepository,
        VotosRepository votosRepository) {
    this.funcionarioRepository = funcionarioRepository;
    this.restauranteRepository = restauranteRepository;
    this.votosRepository = votosRepository;
}

public  List<TotalVotosDosRestaurante> totalDeVotosEmGeral(){
        return votosRepository.TotalVotosDosRestaurante();

}

public void CadVoto(String nome) throws  LimiteDeVotosDiariosException {

        try {
            votosRepository.votar(new Voto(nome, nomeRestaurante));
        }catch (LimiteDeVotosDiariosException e) {
            throw new LimiteDeVotosDiariosException("Falha ao inserir seu voto");
        }



}
}


