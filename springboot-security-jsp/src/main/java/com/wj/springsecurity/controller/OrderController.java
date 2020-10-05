package com.wj.springsecurity.controller;

import com.wj.springsecurity.domain.SysUser;
import com.wj.springsecurity.util.SecurityUtil;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Secured({"ROLE_ORDER"})
    @RequestMapping("/findAll")
    public String findAll(){
        return "order-list";
    }
}
