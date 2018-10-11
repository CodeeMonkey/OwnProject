package com.realdolmen.beans;

import com.realdolmen.domain.PriceChangeEntity;
import com.realdolmen.service.PriceChangeServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PriceChangeBean {

    @Inject
    PriceChangeServiceBean priceChangeService;

    public PriceChangeEntity save(PriceChangeEntity priceChange){ return priceChangeService.save(priceChange); }
    public PriceChangeEntity findById(long priceChangeId){ return priceChangeService.findById(priceChangeId); }
    public List<PriceChangeEntity> findAll(){ return priceChangeService.findAll(); }
    public void remove(long priceChangeId){ priceChangeService.remove(priceChangeId); }


}
