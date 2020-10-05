package com.wj.springsecurity.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public String handlerException(RuntimeException e){
        if(e instanceof AccessDeniedException){
            return "redirect:/403.jsp";
        }else{
            return "redirect:/500.jsp";
        }
    }
}
