package org.aurifa.demo.strutter.service;

import org.aurifa.demo.strutter.model.Message;
import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.exception.NonExistentUserException;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;
import org.hibernate.LockMode;

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

    public Message post( String authorName, String message ) throws NonExistentUserException {
        User author = userService.get(authorName);
        if (author != null) {
            return post(author, message);
        } else {
            throw new NonExistentUserException("User " + authorName + " does not exist");
        }
    }

    @SuppressWarnings({"unchecked"})
    public List<Message> getTimeline(String authorName) {
        return createQuery("from Message where author.alias=:authorName" +
                " or text like '%@'||:authorName||'%'" +
                " order by sent desc")
                .setString("authorName", authorName)
                .list();
    }

    public List<Message> getPosts(String authorName) throws NonExistentUserException {
        User user = userService.get(authorName);
        if (user != null) {
            return user.getMessages();
        } else {
            throw new NonExistentUserException("User " + authorName + " does not exist");
        }
    }

}
