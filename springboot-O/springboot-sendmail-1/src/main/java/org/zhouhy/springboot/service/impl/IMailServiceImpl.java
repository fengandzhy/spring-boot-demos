package org.zhouhy.springboot.service.impl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.service.IMailService;

@Service(value="IMailService")
public class IMailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.from}")
    private String from;
    
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content, String... cc) {

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content, String... cc) {

    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {

    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath, String... cc) {

    }

    @Override
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {

    }

    @Override
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) {

    }
}
