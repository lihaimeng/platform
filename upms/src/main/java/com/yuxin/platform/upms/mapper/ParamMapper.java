package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface ParamMapper {
    int deleteByPrimaryKey(Integer paramId);

    int insert(Param record);

    int insertSelective(Param record);

    Param selectByPrimaryKey(Integer paramId);

    int updateByPrimaryKeySelective(Param record);

    int updateByPrimaryKey(Param record);

    List<Param> selectParam();

    Param selectByCode(String code);


}