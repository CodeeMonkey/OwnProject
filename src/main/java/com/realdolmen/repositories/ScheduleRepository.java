package com.realdolmen.repositories;

import com.realdolmen.domain.AirportEntity;
import com.realdolmen.domain.AirportEntity_;
import com.realdolmen.domain.ScheduleEntity;
import com.realdolmen.domain.ScheduleEntity_;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class ScheduleRepository implements Serializable{

    @PersistenceContext
    private EntityManager em;

    private List<String> globalRegions;

    private void getRegionList(){
        Query query = em.createNamedQuery(AirportEntity.GET_REGIONS);
        if (globalRegions == null || globalRegions.isEmpty()){ globalRegions = query.getResultList();}
        System.out.println("1) regions");
        for (String n : globalRegions) {System.out.println(n);}

    }

    private boolean isRegion (String airport) {
        System.out.println("2) enter isRegion with " + airport);
        if (globalRegions.contains(airport)) {
            System.out.println("2.1) " + airport + " is a region?: " + globalRegions.contains(airport));
            return true; }
        System.out.println("2.1) " + airport + " is a region?: " + globalRegions.contains(airport));
        return false;
    }

    public List<ScheduleEntity> findAvailableSchedules(String date, String depAirp, String destAirp, int bookedSeats, String classChoice) {
        //get regions with first call
        getRegionList();

        //build query
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ScheduleEntity> query = builder.createQuery(ScheduleEntity.class);
        Root<ScheduleEntity> scheduleEntity = query.from(ScheduleEntity.class);
        query.select(scheduleEntity);
        Join<ScheduleEntity, AirportEntity> arrAirportJoin = scheduleEntity.join(ScheduleEntity_.arrivalAirtportFK);
        Join<ScheduleEntity, AirportEntity> depAirportJoin = scheduleEntity.join(ScheduleEntity_.departureAirtportFK);

        //build criteria
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(scheduleEntity.get(ScheduleEntity_.date), date));

        //region or airport selector
        if (isRegion(destAirp)) {
            predicates.add(builder.equal(arrAirportJoin.get(AirportEntity_.globalRegionLocation), destAirp));
        }else {
            predicates.add(builder.equal(arrAirportJoin.get(AirportEntity_.airportName), destAirp));
        }

        if (isRegion(depAirp)) {
            predicates.add(builder.equal(depAirportJoin.get(AirportEntity_.globalRegionLocation), depAirp));
        } else {
            predicates.add(builder.equal(depAirportJoin.get(AirportEntity_.airportName), depAirp));
        }

        //class selector
        switch (classChoice) {
            case ("Economy"):
                predicates.add(builder.ge(scheduleEntity.get(ScheduleEntity_.remainingSeatsEconomy), bookedSeats));
                break;
            case ("Business"):
                predicates.add(builder.ge(scheduleEntity.get(ScheduleEntity_.remainingSeatsBusiness), bookedSeats));
                break;
            case ("First class"):
                predicates.add(builder.ge(scheduleEntity.get(ScheduleEntity_.remainingSeatsFirst), bookedSeats));
                break;
        }

        //add predicates
        query.where(predicates.toArray(new Predicate[]{}));
        query.orderBy(builder.asc(scheduleEntity.get(ScheduleEntity_.defaultPrice)),builder.asc(scheduleEntity.get(ScheduleEntity_.departureTime)));
        TypedQuery<ScheduleEntity> q = em.createQuery(query);
        System.out.println("3) query results " + q.getResultList().size());
        return q.getResultList();
    }
}
