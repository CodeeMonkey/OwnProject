package com.realdolmen.service.remotes;

import com.realdolmen.domain.PriceChangeEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PriceChangeServiceRemote {
    PriceChangeEntity save(PriceChangeEntity priceChange);
    PriceChangeEntity findById(Long id);
    List<PriceChangeEntity> findAll();
    void remove(long priceChangeId);
}
