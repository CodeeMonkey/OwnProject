package com.realdolmen.beans;

import com.realdolmen.domain.BookedflightEntity;
import com.realdolmen.service.BookedFlightServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BookedFlightBean {

    @Inject
    BookedFlightServiceBean bookedFlightService;

    public BookedflightEntity save(BookedflightEntity bookedFlight){ return bookedFlightService.save(bookedFlight); }
    public BookedflightEntity findById(long bookedFlightId){ return bookedFlightService.findById(bookedFlightId); }
    public List<BookedflightEntity> findAll(){ return bookedFlightService.findAll(); }
    public void remove(long bookedFlightId){ bookedFlightService.remove(bookedFlightId); }


}
