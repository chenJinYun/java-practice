package pers.kim.merchant.jms;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import pers.kim.merchant.pojo.User;

import javax.jms.*;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    public Queue queue;

    public void send(final User user) {
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage(JSON.toJSONString(user));
                return msg;
            }
        });
    }
}
