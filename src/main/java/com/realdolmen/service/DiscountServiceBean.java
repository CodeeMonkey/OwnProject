package com.realdolmen.service;

import com.realdolmen.domain.DiscountEntity;
import com.realdolmen.domain.DiscountEntity;
import com.realdolmen.repository.AirportRepository;
import com.realdolmen.repository.DiscountRepository;
import com.realdolmen.service.remotes.AirportServiceRemote;
import com.realdolmen.service.remotes.DiscountServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class DiscountServiceBean implements DiscountServiceRemote {

    @EJB
    DiscountRepository discountRepository;

    @Override
    public DiscountEntity save(DiscountEntity discount) { return discountRepository.save(discount); }

    @Override
    public DiscountEntity findById(Long id) { return discountRepository.findById(id); }

    @Override
    public List<DiscountEntity> findAll() { return discountRepository.findAll(); }

    @Override
    public void remove(long discountId) { discountRepository.remove(discountId); }
}
