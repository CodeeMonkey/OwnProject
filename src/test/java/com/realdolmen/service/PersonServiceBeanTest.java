package com.realdolmen.service;


import com.realdolmen.beans.UserBean;
import com.realdolmen.togethair.AbstractWeldContainerTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PersonServiceBeanTest extends AbstractWeldContainerTest {
    private UserBean personService;

    @Before
    public void initialize() {
        personService = container.instance().select(UserBean.class).get();
    }

    @Test
    public void personServiceHasPersonRepository() throws Exception {
        assertNotNull(personService);
        personService.findAll();
        personService.findById(1000L);
        //assertNotNull(personService.personRepository);
    }
}