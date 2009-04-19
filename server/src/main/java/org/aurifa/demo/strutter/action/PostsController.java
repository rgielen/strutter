package org.aurifa.demo.strutter.action;

import com.opensymphony.xwork2.ValidationAwareSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import org.aurifa.demo.strutter.model.Message;
import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.service.MessageService;
import org.aurifa.demo.strutter.service.UserService;
import org.aurifa.demo.strutter.exception.NonExistentUserException;
import org.aurifa.demo.strutter.helper.Replicator;
import org.aurifa.demo.strutter.helper.HibernateLazyKillingReplicator;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;

/**
 * <code>PostsController</code>
 *
 * @author <a href="mailto:hermanns@aixcept.de">Rainer Hermanns</a>
 * @version $Id: $
 */
@Results({
                @Result(name="success", type="redirectAction", params = {"actionName", "posts/%{id}"})
})
@Transactional
public class PostsController  extends ValidationAwareSupport implements ModelDriven<Object>, Validateable {

    private User model = new User();
    private Message message = new Message();
    private String id;
    private List<Message> messages = new ArrayList<Message>();

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

    // GET /posts/1
    public HttpHeaders show() {
        try {
            List<Message> temp = messageService.getPosts(model.getAlias());
            Replicator r = new HibernateLazyKillingReplicator();
            for ( Message m : temp) {
                messages.add(r.deepCopy(m));
            }
        } catch (NonExistentUserException e) {

        }
//        messages = messageService.getTestMessages();
        return new DefaultHttpHeaders("show").setLocationId(model.getAlias()).disableCaching();
    }


    public HttpHeaders index() {
        try {
            List<Message> temp = messageService.getPosts(model.getAlias());
            Replicator r = new HibernateLazyKillingReplicator();
            for ( Message m : temp) {
                messages.add(r.deepCopy(m));
            }
        } catch (NonExistentUserException e) {

        }
//        messages = messageService.getTestMessages();
        return new DefaultHttpHeaders("show").setLocationId(model.getAlias()).disableCaching();
    }


    // POST /posts
    public HttpHeaders create() {
        if ( model != null) {
            message.setAuthor(model);
            message = messageService.saveOrUpdate(message);
            addActionMessage("New Message created successfully");
        } else {
            addActionError("User '"+ model.getAlias() + "' is unknown");
            return new DefaultHttpHeaders("error");
        }

        return new DefaultHttpHeaders("success").setLocationId(model.getAlias());
    }

    // GET /posts/1/editNew
    public HttpHeaders editNew() {
        message = new Message();
        //return "editNew";
        return new DefaultHttpHeaders("editNew").setLocationId(model.getAlias()).disableCaching();
    }


    // GET /posts/1/deleteConfirm
    public String deleteConfirm() {
        return "deleteConfirm";
    }

    // DELETE /posts/1
    public String destroy() {
        message = messageService.get(message.getId());
        messageService.delete(message);
        addActionMessage("Message removed successfully");
        return "success";
    }
    
    public void setId(String id) {
        if ( id != null) {
            model = userService.get(id);
        }

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getModel() {
        return (messages != null ? messages : model);
    }

    public void validate() {
        if ( message.getText() == null || message.getText().length() == 0) {
            addFieldError("text", "The message text is empty");
        }

    }
}
