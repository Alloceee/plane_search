package com.yws.plane.config;

import com.yws.plane.entity.Manager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor");
        //flag变量用于判断用户是否登录，默认为false
        boolean flag = false;
        //拦截请求
        //1.获取session中的用户
        Manager admin = (Manager) request.getSession().getAttribute("admin");
        //2.判断用户是否已经登录
        if (admin == null) {
            //如果用户没有登录，则设置提示信息，跳转到登录界面
            request.setAttribute("message", "请先登录再访问网站");
            response.sendRedirect("/admin/index");
        } else {
            //如果用户已经登录，则验证通过，放行
            flag = true;
        }
        return flag;
    }
}
