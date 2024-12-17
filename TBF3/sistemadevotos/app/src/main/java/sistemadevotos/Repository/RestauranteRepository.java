package main.java.sistemadevotos.model.Repository;

import java.util.List;

public class RestauranteRepository {

    private EntityManager em;

    public RestaurantesRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
    }

    public void inserirRest(Restaurantes restaurantes) {
        this.em.getTransaction().begin();
        this.em.merge(restaurantes);
        this.em.getTransaction().commit();

}

public Restaurantes buscarRestId(Integer id) {
        return  this.em.find(Restaurantes.class, id);
}

public List<Restaurantes> listar(){
    TypedQuery<Restaurantes> buscarTodosQuery =
    this.em.createQuery("select e from Restaurantes e order by e.nome", Restaurantes.class);
        return buscarTodosQuery.getResultList();
}
public List<Restaurantes> buscarPorNomeApp(String nome) {
    TypedQuery<Restaurantes> buscarTodosQuery =
            this.em.createQuery("select e from Restaurantes e where UPPER(e.nome) like :nome order by e.nome", Restaurantes.class);
    buscarTodosQuery.setParameter("nome", nome.toUpperCase()+"%");

    return buscarTodosQuery.getResultList();
}

}
