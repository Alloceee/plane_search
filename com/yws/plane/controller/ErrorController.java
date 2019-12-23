package com.yws.plane.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理类
 *
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 20:52
 * @Project: plane_search
 */
@ControllerAdvice
public class ErrorController {
    @ExceptionHandler
    public String error(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "/error/404";
    }
}
