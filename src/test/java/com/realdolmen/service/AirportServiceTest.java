package com.realdolmen.service;

import com.realdolmen.beans.AirportBean;
import com.realdolmen.togethair.AbstractWeldContainerTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AirportServiceTest extends AbstractWeldContainerTest {
    private AirportBean airportService;

    @Before
    public void initialize() {
        airportService = container.instance().select(AirportBean.class).get();
    }

    @Test
    public void aircraftServiceHasRepository() throws Exception {
        assertNotNull(airportService);
        airportService.findAll();
        airportService.findById(100L);
        //assertNotNull(airportService.airportRepository);
    }
}
