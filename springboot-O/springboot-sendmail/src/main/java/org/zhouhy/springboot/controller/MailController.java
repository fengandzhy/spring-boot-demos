package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zhouhy.springboot.service.MailService;
import org.zhouhy.springboot.vo.MailVo;

@Slf4j
@RestController
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;
    
    @Autowired
    private MailService mailService;

    /**
     * 发送邮件的主界面
     */
    @GetMapping("/")
    public ModelAndView index() {
        log.info("To the sending page");
        ModelAndView mv = new ModelAndView("mail/sendMail");//打开发送邮件的页面
        mv.addObject("from", mailService.getMailSendFrom());//邮件发信人
        return mv;
    }

    @GetMapping("/simple")
    public String simple() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人邮箱
        message.setFrom(this.mailProperties.getUsername());
        // 收信人邮箱
        message.setTo("fengandzhy@126.com");
        // 邮件主题
        message.setSubject("简单邮件测试");
        // 邮件内容
        message.setText("简单邮件测试");
        this.javaMailSender.send(message);
        return "success";
    }

    
    /**
     * 发送邮件
     */
    @PostMapping("/mail/send")
    public MailVo sendMail(MailVo mailVo, MultipartFile[] files) {
        mailVo.setMultipartFiles(files);
        return mailService.sendMail(mailVo);//发送邮件和附件
    }
}
