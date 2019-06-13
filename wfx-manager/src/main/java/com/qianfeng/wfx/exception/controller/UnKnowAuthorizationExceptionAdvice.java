package com.qianfeng.wfx.exception.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 权限异常拦截
 */
@ControllerAdvice
public class UnKnowAuthorizationExceptionAdvice {

    @ExceptionHandler(AuthorizationException.class)
    public String toErrorPage(){
        //TODO
        return "nopermission";

    }
}
