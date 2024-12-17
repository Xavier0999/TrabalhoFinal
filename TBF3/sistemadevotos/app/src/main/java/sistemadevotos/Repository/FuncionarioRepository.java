package main.java.sistemadevotos.model.Repository;

import java.util.List;

import main.java.sistemadevotos.model.Funcionario;



/**
 * Repositório responsável pela manipulação de dados da entidade {@link Funcionario}.
 * Contém operações para inserir, buscar e listar funcionários no banco de dados.
 */
public class FuncionarioRepository {
private EntityManager em;


/**
     * Construtor da classe FuncionarioRepository.
     * Inicializa o EntityManager a partir de uma EntityManagerFactory.
     */
    public FuncionarioRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
    }


/**
     * Insere ou atualiza um funcionário no banco de dados.
     * Se o funcionário já existir, ele será atualizado; caso contrário, será inserido.
     *
     * @param funcionario o objeto {@ Funcionario} a ser persistido no banco de dados.
     */

    public void inserirFunc(Funcionario funcionario) {
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();

}

/**
     * Busca um funcionário pelo seu ID.
     *
     * @param id o identificador único do funcionário.
     * @return o objeto {@link Funcionario} correspondente ao ID fornecido ou null se não encontrado.
     */
public Funcionario buscarFuncId(Integer id) {
        return  this.em.find(Funcionario.class, id);
}

/**
     * Lista todos os funcionários cadastrados no banco de dados, ordenados por nome.
     *
     * @return uma lista de objetos {@link Funcionario}.
     */


public List<Funcionario> listar(){
    TypedQuery<Funcionario> buscarTodosQuery =
    this.em.createQuery("select e from Funcionario e order by e.nome", Funcionario.class);
        return buscarTodosQuery.getResultList();
}


 /**
     * Busca funcionários pelo nome, realizando uma pesquisa que utiliza o início do nome fornecido.
     * A busca não diferencia maiúsculas de minúsculas.
     *
     * @param nome o prefixo do nome do funcionário a ser buscado.
     * @return uma lista de objetos {@link Funcionario} que correspondem ao critério de busca.
     */

public List<Funcionario> buscarFuncPorNomeApp(String nome) {
    TypedQuery<Funcionario> buscarTodosQuery =
            this.em.createQuery("select e from Funcionario e where UPPER(e.nome) like :nome order by e.nome", Funcionario.class);
    buscarTodosQuery.setParameter("nome", nome.toUpperCase()+"%");

    return buscarTodosQuery.getResultList();
}
}

