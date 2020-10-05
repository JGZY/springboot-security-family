package com.wj.springsecurity.controller;

import com.wj.springsecurity.domain.SysUser;
import com.wj.springsecurity.util.SecurityUtil;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Secured({"ROLE_USER"})
    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
