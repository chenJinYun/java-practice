package pers.kim.administrator.jms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.kim.administrator.pojo.User;
import pers.kim.administrator.service.UserManager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@Component
public class MyListener implements MessageListener {
    @Autowired
    private UserManager userManager;
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage= (TextMessage) message;
        try {
            User user =JSON.parseObject(textMessage.getText(),User.class);
            userManager.addUser(user);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
