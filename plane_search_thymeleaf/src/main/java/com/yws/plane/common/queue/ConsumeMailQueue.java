package com.yws.plane.common.queue;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yws.plane.entity.Email;
import com.yws.plane.service.home.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消费队列
 * 创建者 科帮网
 * 创建时间	2017年8月4日
 */
@Component
public class ConsumeMailQueue {
	private static final Logger logger = LoggerFactory.getLogger(ConsumeMailQueue.class);
	@Reference(check = false)
	MailService mailService;
	
	@PostConstruct
	public void startThread() {
		ExecutorService e = Executors.newFixedThreadPool(2);// 两个大小的固定线程池
		e.submit(new PollMail(mailService));
		e.submit(new PollMail(mailService));
	}

	class PollMail implements Runnable {
		MailService mailService;

		public PollMail(MailService mailService) {
			this.mailService = mailService;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Email mail = MailQueue.getMailQueue().consume();
					if (mail != null) {
						logger.info("剩余邮件总数:{}",MailQueue.getMailQueue().size());
						mailService.send(mail);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@PreDestroy
	public void stopThread() {
		logger.info("destroy");
	}
}
