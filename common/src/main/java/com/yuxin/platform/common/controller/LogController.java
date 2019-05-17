/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
package com.yuxin.platform.common.controller;

import com.yuxin.platform.common.model.Log;
import com.yuxin.platform.common.service.LogService;
import com.yuxin.platform.upms.dto.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 查询日志
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/selectLog", method = RequestMethod.GET)
    public List<Log> organizationBypid(@RequestParam Map<String, Object> map) {
        List<Log> logs = logService.selectLog(map);
        return logs;
    }

    /**
     * 条件查询日志
     *
     * @param logDto
     * @return
     */
    @RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
    public List<Log> selectByCondition(@RequestBody LogDto logDto) {
        List<Log> logs = logService.selectByCondition(logDto);
        return logs;
    }

}
