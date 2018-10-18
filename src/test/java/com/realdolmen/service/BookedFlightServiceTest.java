package com.realdolmen.service;

import com.realdolmen.beans.BookedFlightBean;
import com.realdolmen.togethair.AbstractWeldContainerTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BookedFlightServiceTest extends AbstractWeldContainerTest {

	private BookedFlightBean bookedFlightService;
	
    @Before
    public void initialize() {
    	bookedFlightService = container.instance().select(BookedFlightBean.class).get();
    }

    @Test
    public void bookedFlightServiceHasRepository() throws Exception {
        assertNotNull(bookedFlightService);
        bookedFlightService.findAll();
        bookedFlightService.findById(100L);
        //assertNotNull(bookedFlightService.bookedFlightRepository);
    }
}
