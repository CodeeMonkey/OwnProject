package com.realdolmen.beans;

import com.realdolmen.domain.CustomerEntity;
import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.domain.PartnerEmployeeEntity;
import com.realdolmen.domain.UserEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUserBean implements Serializable {

    private static UserEntity currentUser;

    public static Boolean isLoggedIn() {
        if(currentUser!= null){
            return true;
        }
        return false;
    }

    public static Boolean isNotLoggedIn() {
           if(currentUser==null){
               return true;
            }else{
                return false;
            }
    }

    public static String logOut(){
        System.out.println("LOG OUT");
        currentUser = null;
        return "index.xhtml";
    }

    public static UserEntity getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserEntity currentUser) {
        CurrentUserBean.currentUser = currentUser;
    }


    public static boolean isPartnerEmployee () {
        if(currentUser instanceof PartnerEmployeeEntity){
            System.out.println("Partner");
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmployee() {
        if(currentUser instanceof EmployeeEntity){
            System.out.println("Employee");
            return true;
        }else{
            return false;
        }
    }

    public static boolean isCustomer() {
        if(currentUser instanceof CustomerEntity){
            System.out.println("customer");
            return true;
        }else{
            return false;
        }
    }

}