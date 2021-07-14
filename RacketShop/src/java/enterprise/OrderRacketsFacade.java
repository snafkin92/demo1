/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

import entity.OrderRackets;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author snafkin
 */
@Stateless
public class OrderRacketsFacade extends AbstractFacade<OrderRackets> {

    @PersistenceContext(unitName = "RacketShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderRacketsFacade() {
        super(OrderRackets.class);
    }
    
}
