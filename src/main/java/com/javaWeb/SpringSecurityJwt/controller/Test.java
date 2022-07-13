package com.javaWeb.SpringSecurityJwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class Test {
    @GetMapping("/admin")
    public String admin(){
        return "day la admin";
    }

    @GetMapping("/test")
    public String user(){
        return "day la user";
    }

}
