package com.realdolmen.service;

import org.junit.Before;
import org.junit.Test;

import com.realdolmen.beans.AircraftBean;
import com.realdolmen.togethair.AbstractWeldContainerTest;

import static org.junit.Assert.assertNotNull;

public class AircraftServiceTest extends AbstractWeldContainerTest {
    private AircraftBean aircraftService;

    @Before
    public void initialize() {
        aircraftService = container.instance().select(AircraftBean.class).get();
    }

    @Test
    public void aircraftServiceIsInvoked() throws Exception {
        assertNotNull(aircraftService);
        aircraftService.findAll();
        aircraftService.findById(100L);
    }
}
