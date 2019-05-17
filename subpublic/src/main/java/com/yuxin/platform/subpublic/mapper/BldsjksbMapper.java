package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.Bldsjksb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BldsjksbMapper {
    int deleteByPrimaryKey(Integer qyid);

    int insert(Bldsjksb record);

    int insertSelective(Bldsjksb record);

    Bldsjksb selectByPrimaryKey(Integer qyid);

    List<Bldsjksb> selectBldsjksb(Integer qyid);

    int updateByPrimaryKeySelective(Bldsjksb record);

    int updateByPrimaryKey(Bldsjksb record);
}