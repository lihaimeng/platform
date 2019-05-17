package com.yuxin.platform.common.controller;

import com.yuxin.platform.common.core.SystemLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author jyh
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String name() {
        return "redirect:index.html";
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "redirect:index.html";
    }

    @RequestMapping(value = "userlogout", method = RequestMethod.GET)
    @SystemLog(description = "登出")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login.html";
    }
}
