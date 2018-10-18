package com.realdolmen.service;

import com.realdolmen.beans.AirlineBean;
import com.realdolmen.togethair.AbstractWeldContainerTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AirlineServiceTest extends AbstractWeldContainerTest {
    private AirlineBean airlineService;

    @Before
    public void initialize() {
        airlineService = container.instance().select(AirlineBean.class).get();
    }

    @Test
    public void aircraftServiceHasRepository() throws Exception {
        assertNotNull(airlineService);
        airlineService.findAll();
        airlineService.findById(100L);
        //assertNotNull(airlineService.airlineRepository);
    }
}
