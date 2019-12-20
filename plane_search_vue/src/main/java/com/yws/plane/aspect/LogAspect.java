package com.yws.plane.aspect;

import com.yws.plane.entity.Log;
import com.yws.plane.repository.LogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 采用springAOP进行日志管理
 *
 * @author AlmostLover
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private LogRepository logRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

//    @Pointcut("execution(public * com.yws.plane.controller.home.*.*(..))")
//    public void webLog() {
//    }

//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) {
//        //接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//        Log log = new Log();
//        //请求url
//        log.setUrl(request.getRequestURL().toString());
//        //请求IP
//        log.setIp(request.getRemoteAddr());
//        //请求方法参数
//        log.setArgs(Arrays.toString(joinPoint.getArgs()));
////        LOGGER.info("请求类方法 : "+joinPoint.getSignature())
//        System.out.println(log);
//        logRepository.save(log);
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) {
//        //处理完请求，返回内容
////        LOGGER.info("REQUEST : "+ret);
//    }
}
