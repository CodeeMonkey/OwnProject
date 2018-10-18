package com.realdolmen.beans;

import com.realdolmen.domain.CustomerEntity;
import com.realdolmen.domain.LoginEntity;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
@Stateful
public class CustomerBean implements Serializable {

    @Size(min=2, message = "This field must contain at least 2 letters")
    @Pattern(regexp = "^[a-zA-Z \'-]+$", message = "This field can only contain letters")
    private String firstName;
    @Size(min=1, message = "This field must contain at least 1 letter")
    @Pattern(regexp = "^[a-zA-Z \'-]+$", message = "This field can only contain letters")
    private String lastName;
    @Size(min=2, message = "This field must contain at least 2 letters")
    @Pattern(regexp = "^[a-zA-Z -]+$", message = "This field can only contain letters")
    private String country;
    @Pattern(regexp="^(?=^.{9,11}$)0\\d*-?\\d*$", message = "Please enter a valid phone number")
    private String phoneNumber;
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "please enter a valid email")
    private String email;
    @Size(min=6, message = "Your password must contain at least 6 characters")
    private String password1;
    @Size(min=6, message = "Your password must contain at least 6 characters")
    private String password2;
    @Past(message = "Are you born in the future?")
    private Date birthDate;

    @Inject
    LoginBean loginBean;

    @PersistenceContext
    EntityManager em;

    //CustomerEntity currentCustumor =
    //CRUDS
    public CustomerEntity save(CustomerEntity user) {
        em.persist(user);
        return user;
    }

    public CustomerEntity findById(Long id) {
        return em.find(CustomerEntity.class, id);
    }

    public List<CustomerEntity> findAll() {
        return em.createQuery("select p from CustomerEntity p", CustomerEntity.class).getResultList();
    }

    public void remove(long userId) {
        em.remove(em.getReference(CustomerEntity.class, userId));
    }
    //END CRUDS

    public String fromBooking() {
        System.out.println("loginBean.fromBooking");
        loginBean.setRedirectURL("bookingVisitor.xthtml");
        return "register.xhtml";
    }

    public String register(){
        if(!password1.equals(password2)){
            FacesContext.getCurrentInstance().addMessage("btn", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Passwords doens't match"));
            return "";
        }else{
            //password1 = Password.hashPassword(password1);
            LoginEntity login = new LoginEntity(email, password1);
            loginBean.save(login);
            CustomerEntity customer = new CustomerEntity(firstName, lastName, country, phoneNumber, birthDate, login);
            save(customer);
            return "login.xhtml";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
