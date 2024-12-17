package main.java.sistemadevotos.model.Repository;

import java.util.Calendar;
import java.util.List;

import main.java.sistemadevotos.model.TotalVotosDosRestaurante;



/**
 * Repositório responsável pela persistência e recuperação de dados da entidade {@code Voto}.
 * <p>
 * Esta classe gerencia operações como registrar votos, calcular o total de votos por restaurante
 * e verificar votos diários de funcionários.
 * </p>
 *
 * @author [Gustavo]
 * @version 1.0
 */

public class VotosRepository {

    private EntityManager em;
 
    /**
     * Construtor padrão da classe {@code VotoRepository}.
     * <p>
     * Inicializa o {@code EntityManager} utilizando uma fábrica de gerenciadores de entidades (EntityManagerFactory).
     * A unidade de persistência {@code DB} é utilizada como configuração.
     * </p>
     */

    public VotoRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
    }
/**
     * Registra ou atualiza um voto no banco de dados.
     *
     * @param votos O objeto {@code Votos} a ser persistido.
     */
    public void votar(Votos votos) {
        this.em.getTransaction().begin();
        this.em.merge(votos);
        this.em.getTransaction().commit();
    }

     /**
     * Retorna o total de votos agrupados por restaurante.
     * <p>
     * A consulta utiliza um {@code join} entre votos e restaurantes para agrupar a contagem de votos
     * por restaurante e ordena os resultados pelo ID do restaurante.
     * </p>
     *
     * @return Uma lista de {@code TotalVotosDosRestaurante}, contendo o ID do restaurante e a quantidade de votos.
     */
    public List<TotalVotosDosRestaurante> TotalVotosDosRestaurante() {
        String query = "select new main.java.sistemadevotos.model.TotalVotosDosRestaurante(e.id, COUNT(c.id)) " +
                "   from Voto c " +
                " inner join c.restaurante e " +
                "  group by e.id order by e.id";

        TypedQuery<TotalVotosDosRestaurante>  TotalVotosDosRestauranteQuery =
                this.em.createQuery(query, TotalVotosDosRestaurante.class);
        return TotalVotosDosRestauranteQuery.getResultList();
    }
/**
     * Verifica se um funcionário já votou em um determinado dia.
     * <p>
     * Este método realiza uma contagem dos votos do funcionário para a data fornecida.
     * Se o número de votos for maior que zero, o funcionário já votou naquele dia.
     * </p>
     *
     * @param funcionario O identificador (ID) do funcionário.
     * @param data        A data em que a verificação será feita.
     * @return {@code true} se o funcionário já votou no dia; {@code false} caso contrário.
     */
    public boolean VotosPorDia(Integer Funcionario, Calendar data) {
        TypedQuery<Long> guriDaAugusta = em.createQuery(
         "SELECT  COUNT(g) FROM Voto g WHERE g.funcionario.id = id AND g.data = data", Long.class);
         guriDaAugusta.setParameter("id", funcionario);
         guriDaAugusta.setParameter("data", data, TemporalType.DATE);    
         return guriDaAugusta.getSingleResult() > 0;

    }


}

