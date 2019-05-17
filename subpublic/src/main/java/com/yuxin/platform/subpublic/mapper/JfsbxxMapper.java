package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.Jfsbxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JfsbxxMapper {
    int deleteByPrimaryKey(Integer qyid);

    int insert(Jfsbxx record);

    int insertSelective(Jfsbxx record);

    Jfsbxx selectByPrimaryKey(Integer qyid);

    List<Jfsbxx> selectJfsbxx(Integer qyid);

    int updateByPrimaryKeySelective(Jfsbxx record);

    int updateByPrimaryKey(Jfsbxx record);
}