package com.yuxin.platform.common.mapper;

import com.yuxin.platform.common.model.Log;
import com.yuxin.platform.upms.dto.LogDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface LogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

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
}