package com.realdolmen.service.remotes;

import com.realdolmen.domain.LoginEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface LoginServiceRemote {
    LoginEntity save(LoginEntity user);
    LoginEntity findById(Long id);
    List<LoginEntity> findAll();
    void remove(long userId);
}
