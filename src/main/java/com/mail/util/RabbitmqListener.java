package com.mail.util;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import com.mail.domain.Mail.mail;
@Component
public class RabbitmqListener implements MessageListener{

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			mail m= mail.parseFrom(message.getBody());
			new MailSender().send(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
