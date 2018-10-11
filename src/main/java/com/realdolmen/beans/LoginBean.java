package com.realdolmen.beans;

import com.realdolmen.domain.LoginEntity;
import com.realdolmen.service.LoginServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class LoginBean {

    @Inject
    LoginServiceBean loginService;

    public LoginEntity save(LoginEntity login){ return loginService.save(login); }
    public LoginEntity findById(long loginId){ return loginService.findById(loginId); }
    public List<LoginEntity> findAll(){ return loginService.findAll(); }
    public void remove(long loginId){ loginService.remove(loginId); }


}
