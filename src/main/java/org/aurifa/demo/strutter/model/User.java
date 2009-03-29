package org.aurifa.demo.strutter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

/**
 * User.
 *
 * @author Rene Gielen
 */
@Entity
public class User {

    String alias;
    String realname;
    String shortBio;
    List<Message> messages;

    public User() {
    }

    public User( String alias, String realname, String shortBio ) {
        this.alias = alias;
        this.realname = realname;
        this.shortBio = shortBio;
    }

    @Id
    public String getAlias() {
        return alias;
    }

    public void setAlias( String alias ) {
        this.alias = alias;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname( String realname ) {
        this.realname = realname;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio( String shortBio ) {
        this.shortBio = shortBio;
    }

    @OneToMany(mappedBy = "author")
    @OrderBy("sent desc")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages( List<Message> messages ) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "alias='" + alias + '\'' +
                ", realname='" + realname + '\'' +
                ", shortBio='" + shortBio + '\'' +
                '}';
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (alias != null ? !alias.equals(user.alias) : user.alias != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return alias != null ? alias.hashCode() : 0;
    }
}
