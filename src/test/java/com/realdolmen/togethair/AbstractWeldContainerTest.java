package com.realdolmen.togethair;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class AbstractWeldContainerTest {
    protected static WeldContainer container;

    @BeforeClass
    public static void initializeWeldContainer() {
        Weld weld = new Weld();
        container = weld.initialize();
        RequestContext requestContext= container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
        requestContext.activate();
    }

    @AfterClass
    public static void destroyWeldContainer() {
        if(container != null) {
            container.shutdown();
        }
    }
}
