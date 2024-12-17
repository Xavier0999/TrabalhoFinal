package main.java.sistemadevotos.model.Repository;

import java.util.Calendar;
import java.util.List;

import main.java.sistemadevotos.model.TotalVotosDosRestaurante;

public class VotosRepository {

    private EntityManager em;

    public VotoRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
    }

    public void votar(Votos votos) {
        this.em.getTransaction().begin();
        this.em.merge(votos);
        this.em.getTransaction().commit();
    }
    public List<TotalVotosDosRestaurante> TotalVotosDosRestaurante() {
        String query = "select new main.java.sistemadevotos.model.TotalVotosDosRestaurante(e.id, COUNT(c.id)) " +
                "   from Voto c " +
                " inner join c.restaurante e " +
                "  group by e.id order by e.id";

        TypedQuery<TotalVotosDosRestaurante>  TotalVotosDosRestauranteQuery =
                this.em.createQuery(query, TotalVotosDosRestaurante.class);
        return TotalVotosDosRestauranteQuery.getResultList();
    }

    public boolean VotosPorDia(Integer Funcionario, Calendar data) {
        TypedQuery<Long> guriDaAugusta = em.createQuery(
         "SELECT  COUNT(g) FROM Voto g WHERE g.funcionario.id = id AND g.data = data", Long.class);
         guriDaAugusta.setParameter("id", funcionario);
         guriDaAugusta.setParameter("data", data, TemporalType.DATE);    
         return guriDaAugusta.getSingleResult() > 0;

    }


}

