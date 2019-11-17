//package com.yws.plane.aspect;
//
//import com.yws.plane.entity.Error;
//import com.yws.plane.entity.Log;
//import com.yws.plane.repository.ErrorRepository;
//import com.yws.plane.repository.LogRepository;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.thymeleaf.expression.Maps;
//import org.thymeleaf.util.MapUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
///**
// * 采用springAOP进行错误日志管理
// *
// * @author AlmostLover
// */
//@Aspect
//@Component
//public class ErrorAspect {
//    @Autowired
//    private ErrorRepository errorRepository;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorAspect.class);
//
//    @Pointcut("execution(public * com.yws.plane.controller.ErrorController.*(..))")
//    public void webLog() {
//    }
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) {
//        //接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//        Error error = new Error();
//        //请求url
//        error.setUrl(request.getRequestURL().toString());
//        //请求IP
//        error.setIp(request.getRemoteAddr());
//        //请求方法参数
//        error.setArgs(joinPoint.getKind());
//
//        error.setErrorMessage(Arrays.toString(joinPoint.getArgs()));
//
//        System.out.println(error);
//        errorRepository.save(error);
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) {
//        //处理完请求，返回内容
////        LOGGER.info("REQUEST : "+ret);
//    }
//}
