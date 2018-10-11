package com.realdolmen.service;

import com.realdolmen.domain.BookedflightEntity;
import com.realdolmen.repository.AirportRepository;
import com.realdolmen.repository.BookedFlightRepository;
import com.realdolmen.service.remotes.AirportServiceRemote;
import com.realdolmen.service.remotes.BookedFlightServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class BookedFlightServiceBean implements BookedFlightServiceRemote {

    @EJB
    BookedFlightRepository bookedFlightRepository;

    @Override
    public BookedflightEntity save(BookedflightEntity bookedFlight) { return bookedFlightRepository.save(bookedFlight); }

    @Override
    public BookedflightEntity findById(Long id) {
        return bookedFlightRepository.findById(id);
    }

    @Override
    public List<BookedflightEntity> findAll() {
        return bookedFlightRepository.findAll();
    }

    @Override
    public void remove(long bookedFlightId) {
        bookedFlightRepository.remove(bookedFlightId);
    }
}
