package org.aurifa.demo.strutter.action;

import org.aurifa.demo.strutter.service.UserService;
import org.aurifa.demo.strutter.model.User;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;

/**
 * <code>LoginController</code>
 *
 * @author rainer Hermanns
 */
@Results({
                @Result(name="success", type="redirectAction", params = {"actionName", "timeline/%{username}"})
})
public class LoginController {

    String id;
    String username;
    User user;

    @Resource
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public HttpHeaders index() {
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders create() {
        user = userService.get(username);
        if ( user != null)
            return new DefaultHttpHeaders("success").setLocationId(user.getAlias()).disableCaching();
        
        return new DefaultHttpHeaders("error").disableCaching();
    }

    public void setUsername(String username) {
        this.username = username;
        this.id = username;
    }

    public String getUsername() {
        return username;
    }
}
