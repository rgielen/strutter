package org.aurifa.demo.strutter;

import org.springframework.test.AbstractSingleSpringContextTests;

/**
 * AbstractSpringEnabledTest.
 *
 * @author Rene Gielen
 */
public abstract class AbstractSpringEnabledTest extends AbstractSingleSpringContextTests {

    protected static final String[] CONTEXTFILES_TO_LOAD = {
            "classpath:/spring-context-service.xml",
            "classpath:/spring-context-test.xml"
    };

    @Override
    protected String[] getConfigLocations() {
        return CONTEXTFILES_TO_LOAD;
    }

}
