package org.aurifa.demo.strutter.action;

import org.aurifa.demo.strutter.service.MessageService;
import org.aurifa.demo.strutter.model.Message;
import org.aurifa.demo.strutter.model.User;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * <code>TimelineController</code>
 *
 * @author <a href="mailto:hermanns@aixcept.de">Rainer Hermanns</a>
 * @version $Id: $
 */
@Results({
                @Result(name="success", type="redirectAction", params = {"actionName", "timeline"})
})
@Transactional
public class TimelineController implements ModelDriven<Object> {

    @Resource
    MessageService messageService;

    User model = new User();
    List<Message> list;

    public Object getModel() {
        return list != null ? list : model;
    }
}
