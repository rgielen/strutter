package org.aurifa.demo.strutter;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations={"classpath:/strutter-service-context.xml", "classpath:/strutter-test-context.xml"})
public abstract class AbstractSpringEnabledTest {

}
