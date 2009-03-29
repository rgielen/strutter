package org.aurifa.demo.strutter.service;

import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.exception.UserAlreadyExistentException;
import org.springframework.stereotype.Service;

/**
 * UserService.
 *
 * @author Rene Gielen
 */
@Service
public class UserService extends GenericEntityService<User, String> {

    protected Class<User> entityClass() {
        return User.class;
    }

    public User createUser(String alias, String realname, String shortBio) throws UserAlreadyExistentException {
        if (alias != null) {
        	User u = get(alias);
            if (u == null) {
            	u = new User(alias, realname, shortBio);
                save(u);
                return u;
            } else {
                throw new UserAlreadyExistentException("User with alias " + alias + "already exists.");
            }
        } else {
            throw new IllegalArgumentException("Alias has to be provided");
        }
    }

    

}
