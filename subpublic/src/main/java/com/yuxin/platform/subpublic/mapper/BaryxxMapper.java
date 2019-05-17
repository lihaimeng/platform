package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.Baryxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaryxxMapper {

    int deleteByPrimaryKey(Integer qyid);

    int insert(Baryxx record);

    int insertSelective(Baryxx record);

    Baryxx selectByPrimaryKey(Integer qyid);

    List<Baryxx> selectByQyid(Integer qyid);

    int updateByPrimaryKeySelective(Baryxx record);

    int updateByPrimaryKey(Baryxx record);
}