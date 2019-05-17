package com.yuxin.platform.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> processException(Exception exception) {
        LOGGER.info("异常信息 ：" + exception.getMessage());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errCode", exception.getCause());
        map.put("errMsg", exception.getMessage());
        return map;
    }


}
