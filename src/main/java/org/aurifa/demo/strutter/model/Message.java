package org.aurifa.demo.strutter.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Message.
 *
 * @author Rene Gielen
 */
@Entity
@SequenceGenerator(name = "Message_SEQ", sequenceName = "Message_SEQ")
public class Message {

    Long id;
    Date sent;
    String text;
    User author;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Message_SEQ")
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getSent() {
        return sent;
    }

    public void setSent( Date sent ) {
        this.sent = sent;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor( User author ) {
        this.author = author;
    }
}
