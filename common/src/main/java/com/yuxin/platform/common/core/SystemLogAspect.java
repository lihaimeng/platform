package com.yuxin.platform.common.core;

import com.yuxin.platform.common.model.Log;
import com.yuxin.platform.common.service.LogService;
import com.yuxin.platform.upms.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author jyh
 * @create 2018-03-29-15:10
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    //Controller层切点
    @Pointcut("@annotation(com.yuxin.platform.common.core.SystemLog)")
    public void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        User user = null;
        if (null != session.getAttribute("user")) {
            user = (User) session.getAttribute("user");
        }
        //请求的IP
        String ip = request.getRemoteAddr();
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params += (joinPoint.getArgs()[i]) + ";";
            }
        }
        try {/**/
           /* System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人:" + user.getUsername());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);*/

            Log log = new Log();
            log.setAddtime(new Date());
            log.setDescription(getControllerMethodDescription(joinPoint));
            log.setIp(ip);
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            if (user != null) {
                log.setUsername(user.getUsername());
            }
            log.setUri(request.getRequestURI());
            logService.insertSelective(log);
        } catch (Exception ex) {
            //记录本地异常日志
         /*   logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());*/
            System.out.println("出现异常");
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
