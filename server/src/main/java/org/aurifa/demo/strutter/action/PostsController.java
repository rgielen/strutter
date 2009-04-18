package org.aurifa.demo.strutter.action;

import com.opensymphony.xwork2.ValidationAwareSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import org.aurifa.demo.strutter.model.Message;
import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.service.MessageService;
import org.aurifa.demo.strutter.service.UserService;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <code>PostsController</code>
 *
 * @author <a href="mailto:hermanns@aixcept.de">Rainer Hermanns</a>
 * @version $Id: $
 */
@Results({
                @Result(name="success", type="redirectAction", params = {"actionName", "posts"})
})
@Transactional
public class PostsController  extends ValidationAwareSupport implements ModelDriven<Object>, Validateable {

    private Message model = new Message();
    private Long id;
    private String author;
    private List<Message> list;

    @Resource
    MessageService messageService;

    @Resource
    UserService userService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // GET /user/1
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show").disableCaching();
    }

    // GET /user
    public HttpHeaders index() {
        list = messageService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    // POST /user
    public HttpHeaders create() {
        User user = userService.get(model.getAuthor().getAlias());
        if ( user != null) {
            model.setAuthor(user);
            model = messageService.saveOrUpdate(model);
            addActionMessage("New Message created successfully");
        } else {
            addActionError("User '"+ model.getAuthor().getAlias() + "' is unknown");
            return new DefaultHttpHeaders("error");
        }

        return new DefaultHttpHeaders("success").setLocationId(model.getId());
    }

    // UPDATE /user/1
    public String update() {
        model = messageService.saveOrUpdate(model);
        addActionMessage("Message updated successfully");
        return "success";
    }


    // GET /user/1/edit
    public String edit() {
        return "edit";
    }


    // GET /user/new
    public String editNew() {
        model = new Message();
        return "editNew";
    }

    // GET /user/1/deleteConfirm
    public String deleteConfirm() {
        return "deleteConfirm";
    }

    // DELETE /user/1
    public String destroy() {
        messageService.delete(model);
        addActionMessage("Message removed successfully");
        return "success";
    }


    public void setId(Long id) {
        if ( id != null) {
            model = messageService.get(id);
        }

        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getModel() {
        return (list != null ? list : model);
    }

    public void validate() {
        if ( model.getText() == null || model.getText().length() == 0) {
            addFieldError("text", "The message text is empty");
        }

    }
}
