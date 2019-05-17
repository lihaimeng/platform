package com.yuxin.platform.common.listener;

import com.yuxin.platform.common.model.Dictionary;
import com.yuxin.platform.common.service.DictionaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author jyh
 * @create 2018-05-24-17:01
 */
@WebListener
public class ContextListener implements ServletContextListener {

    private DictionaryService dictionaryService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        dictionaryService = ac.getBean(DictionaryService.class);
        List<Dictionary> dictionarie = dictionaryService.selectDictionaryRecords();
        servletContextEvent.getServletContext().setAttribute("dictionaryRecord", dictionarie);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("项目停止");
    }
}
