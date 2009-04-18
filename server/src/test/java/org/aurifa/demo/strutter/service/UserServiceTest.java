package org.aurifa.demo.strutter.service;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.aurifa.demo.strutter.AbstractSpringEnabledTest;
import org.aurifa.demo.strutter.exception.UserAlreadyExistentException;
import org.aurifa.demo.strutter.model.User;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserServiceTest extends AbstractSpringEnabledTest{

    @Resource
    UserService userService;

    @Test
    public void testInjectionSetup() {
        assertNotNull(userService);
        assertNotNull(userService.getCurrentSession());
    }

    @Test
    public void testFindAll() {
        User u1 = new User("foo", null, null);
        userService.save(u1);
        User u2 = new User("bar", null, null);
        userService.save(u2);

        userService.flush();

        List<User> result = userService.findAll();
        for ( User user : result ) {
            assertTrue(result.contains(user));
        }
    }

    @Test
    public void testCreateUser() throws Exception {
        User u = userService.createUser("aUser1", null, null);
        assertNotNull(u);
        User u2 = userService.get("aUser1");
        assertNotNull(u2);

        try {
            userService.createUser("aUser1", null, null);
            fail("Exception expected");
        } catch ( UserAlreadyExistentException e ) {
            // expected
        }
    }

}
