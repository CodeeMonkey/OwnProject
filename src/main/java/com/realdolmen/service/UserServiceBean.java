package com.realdolmen.service;

import com.realdolmen.domain.UserEntity;
import com.realdolmen.repository.UserRepository;
import com.realdolmen.service.remotes.UserServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class UserServiceBean implements UserServiceRemote {

    @EJB
    UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return findAll();
    }

    @Override
    public void remove(long userId) {
        userRepository.remove(userId);
    }
}
