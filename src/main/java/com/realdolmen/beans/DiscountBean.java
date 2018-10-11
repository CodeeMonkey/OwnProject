package com.realdolmen.beans;

import com.realdolmen.domain.DiscountEntity;
import com.realdolmen.service.DiscountServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class DiscountBean {

    @Inject
    DiscountServiceBean discountService;

    public DiscountEntity save(DiscountEntity discount){ return discountService.save(discount); }
    public DiscountEntity findById(long discountId){ return discountService.findById(discountId); }
    public List<DiscountEntity> findAll(){
        return discountService.findAll();
    }
    public void remove(long discountId){
        discountService.remove(discountId);
    }


}
