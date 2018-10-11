package com.realdolmen.service;

import com.realdolmen.domain.PriceChangeEntity;
import com.realdolmen.repository.AirportRepository;
import com.realdolmen.repository.PriceChangeRepository;
import com.realdolmen.service.remotes.AirportServiceRemote;
import com.realdolmen.service.remotes.PriceChangeServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class PriceChangeServiceBean implements PriceChangeServiceRemote {

    @EJB
    PriceChangeRepository priceChangeRepository;

    @Override
    public PriceChangeEntity save(PriceChangeEntity priceChange) { return priceChangeRepository.save(priceChange); }

    @Override
    public PriceChangeEntity findById(Long id) { return priceChangeRepository.findById(id); }

    @Override
    public List<PriceChangeEntity> findAll() { return priceChangeRepository.findAll(); }

    @Override
    public void remove(long priceChangeId) { priceChangeRepository.remove(priceChangeId); }
}
