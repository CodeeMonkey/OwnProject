package com.realdolmen.beans;

import com.realdolmen.domain.AirportEntity;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Named
public class AirportBean implements Serializable {

    @Size(min = 2)
    private String airportName;
    @Size(min = 2)
    private String airportCode;
    @Size(min = 2)
    private String cityCode;
    @Size(min = 2)
    private String cityName;
    @Size(min = 2)
    private String countryCode;
    @Size(min = 2)
    private String countryName;
    @Size(min = 2)
    private String globalRegionLocation;

    @PersistenceContext
    EntityManager em;

    //CRUDS
    public AirportEntity save(AirportEntity airport) {
        em.persist(airport);
        return airport;
    }

    public AirportEntity findById(Long id) {
        return em.find(AirportEntity.class, id);
    }

    public List<AirportEntity> findAll() {
        return em.createQuery("select a from AirportEntity a", AirportEntity.class).getResultList();
    }

    public void remove(long airportId) {
        em.remove(em.getReference(AirportEntity.class, airportId));
    }

    public void createAirport() {
        AirportEntity airportEntity = new AirportEntity(airportCode, airportName, cityCode, cityName, countryCode, countryName, globalRegionLocation);
        System.out.println("Create airport" + airportCode);

        save(airportEntity);
    }
    //END CRUDS

    public List<AirportEntity> getAirports(String query) {
        String airport = "%" + query + "%";

        Query q = em.createQuery("select distinct a from AirportEntity a where a.airportName LIKE :customairport " +
                "OR a.cityName LIKE :customairport OR a.globalRegionLocation LIKE :customairport " +
                "OR a.countryName LIKE :customairport " +
                "order by(case when a.continent = true then a.continent else 2 end), a.airportName ASC", AirportEntity.class);


         return q
                .setParameter("customairport", airport)
                .setMaxResults(10)
                .getResultList();

    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getGlobalRegionLocation() {
        return globalRegionLocation;
    }

    public void setGlobalRegionLocation(String globalRegionLocation) {
        this.globalRegionLocation = globalRegionLocation;
    }
}
