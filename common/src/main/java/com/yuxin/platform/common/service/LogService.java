package com.yuxin.platform.common.service;

import com.yuxin.platform.common.model.Log;
import com.yuxin.platform.upms.dto.LogDto;

import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
public interface LogService {

    /**
     * 查询日志
     *
     * @param map
     * @return
     */
    List<Log> selectLog(Map<String, Object> map);

    /**
     * 条件查询日志
     *
     * @param logDto
     * @return
     */
    List<Log> selectByCondition(LogDto logDto);


    int insertSelective(Log log);
}
