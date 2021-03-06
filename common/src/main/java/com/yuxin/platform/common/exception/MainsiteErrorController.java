package com.yuxin.platform.common.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainsiteErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String handleError(HttpServletRequest request) {
        return request.getServletContext().getContextPath() + "/404.html";
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return null;
    }

}
