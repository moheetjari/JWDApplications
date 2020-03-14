/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author admin
 */
@Named(value = "customerBean")
@RequestScoped
public class CustomerBean {

    private String username;
    private String password;
    private String customerName;
    private int age;
    private Date regDate = new Date();
    private String email;

    /**
     * Creates a new instance of CustomerBean
     */
    public void validateLength(FacesContext context, UIComponent component, Object obj) {
        String str = (String) obj;

        if (str.length() <= 3) {
            ((UIInput) component).setValid(false);

            FacesMessage message = new FacesMessage("Bean: the shoild be greater than 3");
            context.addMessage(component.getClientId(context), message);
        }
    }

    public CustomerBean() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String showData() {
        return "success ";
    }
}
