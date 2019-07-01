package com.leqiang222.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author LeQiang Li
 * @Date Created in 17:08 2019/7/1
 * @Description:
 * @Modified By:
 */
@Controller
public class LoginController {
    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
