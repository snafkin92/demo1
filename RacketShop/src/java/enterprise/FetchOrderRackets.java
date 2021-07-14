package enterprise;

import entity.OrderRackets;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class FetchOrderRackets {
    @PersistenceContext
    EntityManager	em;

    public List<OrderRackets> getHistory(String id){
        TypedQuery<OrderRackets> q = em.createNamedQuery(
                                       OrderRackets.ORDER_HISTORY,
                                       OrderRackets.class);
        q.setParameter("userId", id);
        return	q.getResultList();
    }
}
