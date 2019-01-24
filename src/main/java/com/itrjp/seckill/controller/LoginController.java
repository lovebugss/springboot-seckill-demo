package com.itrjp.seckill.controller;/**
 * Created by renjp on 2019/1/23.
 */

import com.itrjp.seckill.vo.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author renjp
 * @Date 2019/1/23 17:14
 * @Version 1.0
 */

@Controller
public class LoginController {

    @GetMapping("login")
    public String toLogin() {
        return "login";
    }
    @PostMapping("login")
    public void login(@Valid LoginVo login){
        System.out.println(login);
    }

}
