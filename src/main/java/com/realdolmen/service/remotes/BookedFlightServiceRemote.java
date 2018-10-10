package com.realdolmen.service.remotes;

import com.realdolmen.domain.BookedflightEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BookedFlightServiceRemote {
    BookedflightEntity save(BookedflightEntity bookedFlight);
    BookedflightEntity findById(Long id);
    List<BookedflightEntity> findAll();
    void remove(long bookedFlightId);
}
