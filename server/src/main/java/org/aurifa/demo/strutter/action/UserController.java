package org.aurifa.demo.strutter.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;
import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.service.UserService;
import org.aurifa.demo.strutter.exception.UserAlreadyExistentException;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.Resource;
import java.util.List;

/**
 * RESTful UserController.
 *
 * @author Rainer Hermanns
 * @author Rene Gielen
 */
@Results({
                @Result(name="success", type="redirectAction", params = {"actionName", "user"})
})
@Transactional
public class UserController extends ValidationAwareSupport implements ModelDriven<Object>, Validateable {

    private String id;
    private User model = new User();
    private User user;
    private List<User> list;

    @Resource
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // GET /user/1
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show").disableCaching();
    }

    // GET /user
    public HttpHeaders index() {
        list = userService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    // POST /user
    public HttpHeaders create() {
        try {
            model = userService.createUser(model.getAlias(), model.getRealname(), model.getShortBio());
            addActionMessage("New user created successfully");
        } catch (UserAlreadyExistentException e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("success").setLocationId(model.getAlias());
    }

    // UPDATE /user/1
    public String update() {
        model.setRealname(user.getRealname());
        model.setShortBio(user.getShortBio());
        model = userService.saveOrUpdate(model);
        addActionMessage("User updated successfully");
        return "success";
    }
    

    // GET /user/1/edit
    public String edit() {
        return "edit";
    }


    // GET /user/new
    public String editNew() {
        model = new User();
        user = model;
        return "editNew";
    }

    // GET /user/1/deleteConfirm
    public String deleteConfirm() {
        return "deleteConfirm";
    }

    // DELETE /user/1
    public String destroy() {
        userService.delete(model);
        addActionMessage("User removed successfully");
        return "success";
    }


    public Object getModel() {
        return (list != null ? list : model);
    }

    public void setId(String id) {
        if ( id != null) {
            model = userService.get(id);
            user = model;
        }
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void validate() {
        if ( model.getAlias() == null || model.getAlias().length() == 0) {
            addFieldError("alias", "The alias name is empty");
        }
    }
}
