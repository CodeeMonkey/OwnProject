package com.realdolmen.service.remotes;

import com.realdolmen.domain.DiscountEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DiscountServiceRemote {
    DiscountEntity save(DiscountEntity discount);
    DiscountEntity findById(Long id);
    List<DiscountEntity> findAll();
    void remove(long discountId);
}
