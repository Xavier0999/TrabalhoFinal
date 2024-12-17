package main.java.sistemadevotos.model.Repository;

import java.util.List;

/**
 * Repositório responsável pela persistência e recuperação de dados da entidade {@code Restaurantes}.
 * <p>
 * Esta classe gerencia operações de inserção, busca por ID, listagem e busca por nome na base de dados.
 * </p>
 *
 * @author [Gustavo]
 * @version 1.0
 */


public class RestauranteRepository {

    private EntityManager em;



/**
     * Construtor padrão da classe {@code RestaurantesRepository}.
     * <p>
     * Inicializa o {@code EntityManager} utilizando uma fábrica de gerenciadores de entidades (EntityManagerFactory).
     * A unidade de persistência {@code DB} é utilizada como configuração.
     * </p>
     */

    public RestauranteRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
    }
 /**
     * Insere ou atualiza um restaurante no banco de dados.
     *
     * @param restaurantes O objeto {@code Restaurantes} que será persistido ou atualizado.
     */
    public void inserirRest(Restaurante restaurante) {
        this.em.getTransaction().begin();
        this.em.merge(restaurante);
        this.em.getTransaction().commit();

}
 /**
     * Busca um restaurante pelo seu identificador único (ID).
     *
     * @param id O identificador único do restaurante.
     * @return Um objeto {@code Restaurantes} correspondente ao ID fornecido,
     *         ou {@code null} se não for encontrado.
     */
public Restaurante buscarRestId(Integer id) {
        return  this.em.find(Restaurante.class, id);
}
 /**
     * Retorna a lista completa de restaurantes cadastrados, ordenados por nome.
     *
     * @return Uma lista de {@code Restaurantes}, ordenada em ordem alfabética pelo nome.
     */
public List<Restaurante> listar(){
    TypedQuery<Restaurante> buscarTodosQuery =
    this.em.createQuery("select e from Restaurante e order by e.nome", Restaurante.class);
        return buscarTodosQuery.getResultList();
}

 /**
     * Busca restaurantes cujo nome começa com o valor fornecido.
     * <p>
     * A busca não diferencia letras maiúsculas e minúsculas, pois utiliza a função {@code UPPER}.
     * </p>
     *
     * @param nome O prefixo do nome do restaurante a ser buscado.
     * @return Uma lista de {@code Restaurantes} que correspondem ao nome informado.
     */

public List<Restaurante> buscarPorNomeApp(String nome) {
    TypedQuery<Restaurante> buscarTodosQuery =
            this.em.createQuery("select e from Restaurante e where UPPER(e.nome) like :nome order by e.nome", Restaurante.class);
    buscarTodosQuery.setParameter("nome", nome.toUpperCase()+"%");

    return buscarTodosQuery.getResultList();
}

}
