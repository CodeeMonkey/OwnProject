package com.realdolmen.service;

import com.realdolmen.domain.LoginEntity;
import com.realdolmen.repository.LoginRepository;
import com.realdolmen.service.remotes.LoginServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class LoginServiceBean implements LoginServiceRemote {

    @EJB
    LoginRepository loginRepository;

    @Override
    public LoginEntity save(LoginEntity user) {
        return loginRepository.save(user);
    }

    @Override
    public LoginEntity findById(Long id) {
        return loginRepository.findById(id);
    }

    @Override
    public List<LoginEntity> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public void remove(long userId) {
        loginRepository.remove(userId);
    }
}
