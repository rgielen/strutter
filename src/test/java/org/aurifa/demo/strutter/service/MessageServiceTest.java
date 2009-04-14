package org.aurifa.demo.strutter.service;

import org.aurifa.demo.strutter.AbstractSpringEnabledTest;
import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.model.Message;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class MessageServiceTest extends AbstractSpringEnabledTest {

    @Resource
    MessageService messageService;

    @Test
    public void testInjection() {
        assertNotNull(messageService);
    }

    @Test
    public void testPost() {
        User u = new User("palim", null, null);
        messageService.userService.save(u);
        messageService.getCurrentSession().flush();

        try {
            messageService.post(null, "huhu");
            fail("Exception expected");
        } catch (Exception e) {
            //expected
        }

        Message m = messageService.post(u, "huhu");
        messageService.getCurrentSession().flush();

        assertSame(u, m.getAuthor());
        assertTrue(u.getMessages().contains(m));
    }

    @Test
    public void testGetTimeline() {
        // Add your code here
    }

    @Test
    public void testGetPosts() {
        // Add your code here
    }
}
