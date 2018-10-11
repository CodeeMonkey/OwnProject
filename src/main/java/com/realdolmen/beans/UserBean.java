package com.realdolmen.beans;

import com.realdolmen.domain.UserEntity;
import com.realdolmen.service.UserServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserBean {

    @Inject
    UserServiceBean userService;

    public UserEntity save(UserEntity user){ return userService.save(user); }
    public UserEntity findById(long userId){ return userService.findById(userId); }
    public List<UserEntity> findAll(){ return userService.findAll(); }
    public void remove(long userId){ userService.remove(userId); }


}
