package sistemadevotos.controller;

import java.util.List;

import br.org.fundatec.exception.AplicacaoException;
import main.java.sistemadevotos.exception.LimiteDeVotosDiariosException;
import main.java.sistemadevotos.model.TotalVotosDosRestaurante;
import main.java.sistemadevotos.model.Voto;
import main.java.sistemadevotos.model.Repository.FuncionarioRepository;
import main.java.sistemadevotos.model.Repository.RestauranteRepository;
import main.java.sistemadevotos.model.Repository.VotosRepository;
/**
 * Controlador responsável pelo gerenciamento da votação em restaurantes.
 * <p>
 * Esta classe gerencia a interação entre os repositórios de funcionários, restaurantes
 * e votos, permitindo realizar ações como cadastrar votos e recuperar a contagem total
 * de votos dos restaurantes.
 * </p>
 *
 * @author [Gustavo]
 * @version 1.0
 */
public class VotacaoController {

private FuncionarioRepository funcionarioRepository;
private RestauranteRepository restauranteRepository;
private VotosRepository votosRepository;

/**
     * Construtor da classe VotacaoController.
     *
     * @param funcionarioRepository Repositório de funcionários.
     * @param restauranteRepository Repositório de restaurantes.
     * @param votosRepository       Repositório responsável pela gestão dos votos.
     */
public VotacaoController(FuncionarioRepository funcionarioRepository, RestauranteRepository restauranteRepository,
        VotosRepository votosRepository) {
    this.funcionarioRepository = funcionarioRepository;
    this.restauranteRepository = restauranteRepository;
    this.votosRepository = votosRepository;
}
/**
     * Retorna a lista total de votos em geral, agrupada por restaurante.
     *
     * @return Uma lista de {@code TotalVotosDosRestaurante} com os votos contabilizados
     *         para cada restaurante.
     */
public  List<TotalVotosDosRestaurante> totalDeVotosEmGeral(){
        return votosRepository.TotalVotosDosRestaurante();

}
/**
     * Cadastra um voto para um restaurante.
     * <p>
     * Este método registra um voto associado ao nome de um restaurante. Caso o limite
     * diário de votos seja ultrapassado, uma {@code LimiteDeVotosDiariosException} será lançada.
     * </p>
     *
     * @param nome O nome do restaurante a ser votado.
     * @throws LimiteDeVotosDiariosException Se o limite diário de votos for excedido.
     */
public void CadVoto(String nome, String nomeRestaurante) throws  LimiteDeVotosDiariosException {

        try {
            votosRepository.votar(new Voto(nome, nomeRestaurante));
        }catch (LimiteDeVotosDiariosException e) {
            throw new LimiteDeVotosDiariosException("Falha ao inserir seu voto");
        }



}
}


