package com.yuxin.platform.common.service.impl;

import com.yuxin.platform.common.mapper.LogMapper;
import com.yuxin.platform.common.model.Log;
import com.yuxin.platform.common.service.LogService;
import com.yuxin.platform.upms.dto.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 查询日志
     *
     * @param map
     * @return
     */
    @Override
    public List<Log> selectLog(Map<String, Object> map) {
        return logMapper.selectLog(map);
    }

    /**
     * 条件查询日志
     *
     * @param logDto
     * @return
     */
    @Override
    public List<Log> selectByCondition(LogDto logDto) {
        return logMapper.selectByCondition(logDto);
    }

    @Override
    @Transactional
    public int insertSelective(Log log) {
        return logMapper.insertSelective(log);
    }

}
