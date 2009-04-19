package org.aurifa.demo.strutter.action;

import org.aurifa.demo.strutter.service.MessageService;
import org.aurifa.demo.strutter.service.UserService;
import org.aurifa.demo.strutter.model.Message;
import org.aurifa.demo.strutter.model.User;
import org.aurifa.demo.strutter.helper.Replicator;
import org.aurifa.demo.strutter.helper.HibernateLazyKillingReplicator;
import org.aurifa.demo.strutter.exception.NonExistentUserException;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;

import java.util.List;
import java.util.ArrayList;

/**
 * <code>TimelineController</code>
 *
 * @author Rainer Hermanns
 */
@Results({
                @Result(name="success", type="redirectAction", params = {"actionName", "timeline"})
})
@Transactional
public class TimelineController implements ModelDriven<Object> {

    @Resource
    UserService userService;

    @Resource
    MessageService messageService;

    User model = new User();
    
    List<Message> messages = new ArrayList<Message>();
    String id;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    // GET /timeline/1
    public HttpHeaders show() {
        List<Message> temp = messageService.getTimeline(model.getAlias());
        Replicator r = new HibernateLazyKillingReplicator();
        for ( Message m : temp) {
            messages.add(r.deepCopy(m));
        }
        return new DefaultHttpHeaders("show").disableCaching();

    }

    // GET /timeline
    public HttpHeaders index() {
        return new DefaultHttpHeaders("index").disableCaching();
    }    

    public Object getModel() {
        return messages;
    }

    public void setId(String id) {
        if ( id != null) {
            model = userService.get(id);
        }
        this.id = id;
    }
}
