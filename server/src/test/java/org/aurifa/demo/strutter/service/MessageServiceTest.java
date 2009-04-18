package org.aurifa.demo.strutter.service;

import org.aurifa.demo.strutter.AbstractSpringEnabledTest;
import org.aurifa.demo.strutter.exception.NonExistentUserException;
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

import java.util.List;

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
    public void testPost() throws Exception {
        User u = new User("palim", null, null);
        messageService.userService.save(u);
        messageService.getCurrentSession().flush();

        try {
            messageService.post((User) null, "huhu");
            fail("Exception expected");
        } catch (Exception e) {
            //expected
        }

        Message m = messageService.post(u, "huhu");
        messageService.getCurrentSession().flush();

        assertSame(u, m.getAuthor());
        assertTrue(u.getMessages().contains(m));

        try {
            messageService.post("foo", "bar");
            fail("Exception expected");
        } catch (NonExistentUserException e) {
            //expected
        }

        Message m2 = messageService.post("palim", "huhu");
        messageService.getCurrentSession().flush();

        assertSame(u, m2.getAuthor());
        assertTrue(u.getMessages().contains(m2));
    }

    @Test
    public void testGetTimeline() {
        User u = new User("bar", null, null);
        messageService.userService.save(u);
        User u2 = new User("foobar", null, null);
        messageService.userService.save(u2);
        messageService.post(u, "palim");
        messageService.post(u2, "palim @bar palum");
        messageService.post(u, "palum");
        messageService.getCurrentSession().flush();
        messageService.getCurrentSession().clear();

        List<Message> messages = messageService.getTimeline("bar");
        assertNotNull(messages);
        assertEquals(3, messages.size());
    }

    @Test
    public void testGetPosts() throws Exception {
        User u = new User("foo", null, null);
        messageService.userService.save(u);
        messageService.post(u, "palim");
        messageService.post(u, "palum");
        messageService.getCurrentSession().flush();
        messageService.getCurrentSession().clear();

        List<Message> messages = messageService.getPosts("foo");
        assertNotNull(messages);
        assertEquals(2, messages.size());
    }
}
