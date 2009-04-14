package org.aurifa.demo.strutter.service;

import org.aurifa.demo.strutter.model.Message;
import org.aurifa.demo.strutter.model.User;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageService extends GenericEntityService<Message, Long> {

    @Resource
    UserService userService;

    protected Class<Message> entityClass() {
        return Message.class;
    }

    public Message post ( User author, String text ) {
        Assert.notNull(author, "User must be provided");

        if (text!=null) {
            Message m = new Message(author, text);
            save(m);
            author.getMessages().add(0, m);
            return m;
        } else {
            return null;
        }
    }

    public List<Message> getTimeline(User user) {
        return null;
    }

    public List<Message> getPosts(User user) {
        return null;
    }

}
