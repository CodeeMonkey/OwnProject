package com.realdolmen.service.remotes;

import com.realdolmen.domain.UserEntity;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserServiceRemote {
    UserEntity save(UserEntity user);
    UserEntity findById(Long id);
    List<UserEntity> findAll();
    void remove(long userId);
}
