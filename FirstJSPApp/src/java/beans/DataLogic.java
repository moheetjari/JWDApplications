/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Customer;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
@Named(value = "dataLogic")
@Dependent
public class DataLogic {

    EntityManager em;

    /**
     * Creates a new instance of DataLogic
     */
    public DataLogic() {
        em = Persistence.createEntityManagerFactory("jsfpu").createEntityManager();
    }

    public Collection<Customer> getAllCustomer() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }

}
