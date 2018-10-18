package com.realdolmen.beans;

import com.realdolmen.domain.AirlineEntity;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Named
@RequestScoped
@Stateful
public class AirlineBean {

    @Size(min = 2)
    @Pattern(regexp = "^[a-zA-Z \'-]+$", message = "This field can only contain letters")
    private String airlineName;
    @Size(min = 2)
    @Pattern(regexp = "^[a-zA-Z \'-]+$", message = "This field can only contain letters")
    private String airlineCode;

    @PersistenceContext
    EntityManager em;

    //CRUDS
    public AirlineEntity save(AirlineEntity airline) {
        em.persist(airline);
        return airline;
    }

    public AirlineEntity findById(Long id) {
        return em.find(AirlineEntity.class, id);
    }

    public List<AirlineEntity> findAll() {
        return em.createQuery("select p from AirlineEntity p", AirlineEntity.class).getResultList();
    }

    public void remove(long airlineId) {
        em.remove(em.getReference(AirlineEntity.class, airlineId));
    }

    public void createAirline(){
        System.out.println("Create airline");
        AirlineEntity airlineEntity = new AirlineEntity(airlineCode, airlineName);
        save(airlineEntity);
    }

    public void edit(Long id, String name, String code){
        System.out.println(id);
        AirlineEntity airlineEntity = findById(id);
        System.out.println("TOSTRING 1:" + name);
        airlineEntity.setName(name);
        airlineEntity.setCode(code);
        System.out.println("TOSTRING 1:" + airlineEntity.getName());
        em.merge(airlineEntity);
    }
    //END CRUDS

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
}
