/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Customer;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author admin
 */
@Named(value = "dataBean")
@RequestScoped

public class DataBean {

    @Inject
    DataLogic dl;
    Collection<Customer> customers;

    public Collection<Customer> getCustomers() {
        return dl.getAllCustomer();
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    /**
     * Creates a new instance of DataBean
     */
    public DataBean() {
    }

}
