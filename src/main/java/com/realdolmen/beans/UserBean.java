package com.realdolmen.beans;

import com.realdolmen.domain.PersonEntity;
import com.realdolmen.domain.UserEntity;
import com.realdolmen.service.PersonServiceBean;
import com.realdolmen.service.UserServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserBean {

    @Inject
    private UserServiceBean userService;

    public List<UserEntity> allUsers() {
        return userService.findAll();
    }

    public void remove(long userId) {
        userService.remove(userId);
    }

}
