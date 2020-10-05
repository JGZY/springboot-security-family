package com.wj.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Secured({"ROLE_USER"})
    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
