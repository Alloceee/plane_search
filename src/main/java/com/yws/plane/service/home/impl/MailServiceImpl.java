package com.yws.plane.service.home.impl;

import com.yws.plane.common.dynamicquery.DynamicQuery;
import com.yws.plane.common.queue.MailQueue;
import com.yws.plane.entity.Email;
import com.yws.plane.repository.MailRepository;
import com.yws.plane.service.home.MailService;
import com.yws.plane.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
    @Autowired
    private DynamicQuery dynamicQuery;
    @Autowired
    private MailRepository mailRepository;
    @Autowired
    private JavaMailSender mailSender;//执行者
    @Autowired
    private SpringTemplateEngine templateEngine;//thymeleaf
    @Value("${spring.mail.username}")
    public String USER_NAME;//发送者


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    static {
        System.setProperty("mail.mime.splitlongparameters","false");
    }

    @Override
    public String send(Email mail){
        logger.info("发送邮件：{}",mail.getContent());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(USER_NAME);
        message.setTo(mail.getEmail());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailSender.send(message);
        return "";
    }

    @Override
    public void sendAttachmentsMail(Email mail, String filePath) {
        logger.info("发送邮件：{}",mail.getContent());
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(USER_NAME);
            helper.setTo(mail.getEmail());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(), true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //helper.addAttachment("test"+fileName, file);
            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }

    @Override
    public void sendHtml(Email mail) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //这里可以自定义发信名称比如：爪哇笔记
        helper.setFrom(USER_NAME,"爪哇笔记");
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        helper.setText(
                "<html><body><img src=\"cid:springcloud\" ></body></html>",
                true);
        // 发送图片
        File file = ResourceUtils.getFile("classpath:static"
                + Constants.SF_FILE_SEPARATOR + "image"
                + Constants.SF_FILE_SEPARATOR + "springcloud.png");
        helper.addInline("springcloud", file);
        // 发送附件
        file = ResourceUtils.getFile("classpath:static"
                + Constants.SF_FILE_SEPARATOR + "file"
                + Constants.SF_FILE_SEPARATOR + "关注科帮网获取更多源码.zip");
        helper.addAttachment("科帮网", file);
        mailSender.send(message);
    }

    //弃用
    @Override
    public void sendThymeleaf(Email mail) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(USER_NAME);
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        Context context = new Context();
        context.setVariable("email", mail);
        String text = templateEngine.process(mail.getTemplate(), context);
        helper.setText(text, true);
        mailSender.send(message);
    }

    @Override
    public void sendQueue(Email mail) throws Exception {
        MailQueue.getMailQueue().produce(mail);
    }
    @Override
    public void sendRedisQueue(Email mail) throws Exception {
        redisTemplate.convertAndSend("mail",mail);
    }
}
