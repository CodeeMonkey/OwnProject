package com.realdolmen.beans;

import com.realdolmen.domain.LoginEntity;
import com.realdolmen.view.SearchView;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class LoginBean implements Serializable {

    private String emailInput;
    private String passwordInput;
    private String redirectURL = "index.xhtml";

    @PersistenceContext
    EntityManager em;

    private LoginEntity login = new LoginEntity();

    //CRUDS

    public LoginEntity findById(Long id) {
        return em.find(LoginEntity.class, id);
    }

    public LoginEntity save(LoginEntity login) {
        em.persist(login);
        return login;
    }

    public void remove(long userId) {
        em.remove(em.getReference(LoginEntity.class, userId));
    }
    //END CRUDS

    public String getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(String emailInput) {
        this.emailInput = emailInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput = passwordInput;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public String fromBooking() {
        System.out.println("loginBean.fromBooking");
        redirectURL = "bookingVisitor.xhtml";
        return "login.xhtml";
    }

    public String login (){
        Query query = em.createNamedQuery(LoginEntity.SEARCH_BY_EMAIL);
        query.setParameter("email", emailInput);
        List resultList = query.getResultList();
        if (resultList.isEmpty()){
            FacesContext.getCurrentInstance().addMessage("btn", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Invalid email or password."));
        }else{
            login = (LoginEntity) resultList.get(0);
            if (!login.getPassword().equals(passwordInput)){
                FacesContext.getCurrentInstance().addMessage("btn", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Invalid email or password."));
            }else{
                CurrentUserBean.setCurrentUser(login.getUser());
                System.out.println("LOGIN");
                String currentRedirectURL = new String(redirectURL);
                System.out.println(currentRedirectURL);
                redirectURL = "index.xhtml";
                return currentRedirectURL;
            }
        }
        return "";
    }
}