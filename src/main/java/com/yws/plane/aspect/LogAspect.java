package com.yws.plane.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.yws.plane.controller.*.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        LOGGER.info("URL : "+request.getRequestURL().toString());
        LOGGER.info("IP : "+request.getRemoteAddr());
        LOGGER.info("请求类方法 : "+joinPoint.getSignature());
        LOGGER.info("请求类方法参数 : "+ Arrays.toString(joinPoint.getArgs()));
        LOGGER.info("==============================");
    }

    @AfterReturning(returning = "ret" , pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        //处理完请求，返回内容
        LOGGER.info("REQUEST : "+ret);
    }
}
