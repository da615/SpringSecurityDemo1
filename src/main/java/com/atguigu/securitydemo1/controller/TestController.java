package com.atguigu.securitydemo1.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello ok";
    }

    @GetMapping("/index")
    public String index() {
        return "index ok";
    }

    /**
     * Secured 用户具有某个角色可以访问
     * PreAuthorize 进入方法之前先验证，是否有该权限
     * PostAuthorize 进入方法之后做验证，是否有该权限
     * @return
     */
    @GetMapping("/update")
//    @Secured({"ROLE_sale","ROLE_manager"})
    @PreAuthorize("hasAnyAuthority('admins')")
//    @PostAuthorize("hasAnyAuthority('admins')")
    public String update() {
        System.out.println("update......");
        return "update ok";
    }
}
