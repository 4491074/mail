package com.mail.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.mail.domain.Mail.mail;

public class MailSender {

	public ApplicationContext ctx = null;
	
	public MailSender(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");   
	}
	
	public void send(mail mail) throws MessagingException{
		JavaMailSender javaMailSender = (JavaMailSender) ctx.getBean("javaMailSender");
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
		helper.setFrom("18623657744@163.com");//发件人    
		helper.setTo(mail.getGetter());//收件人    
		helper.setReplyTo("592609088@qq.com");//回复到   
		helper.setSubject(mail.getTitle());//邮件主题    
		helper.setText(mail.getContent(), true);//true表示设定html格式   
		javaMailSender.send(mime);
	}
}
