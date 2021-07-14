/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

import entity.OrderState;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author snafkin
 */
@Stateless
public class OrderStateFacade extends AbstractFacade<OrderState> {

    @PersistenceContext(unitName = "RacketShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderStateFacade() {
        super(OrderState.class);
    }
    
}
