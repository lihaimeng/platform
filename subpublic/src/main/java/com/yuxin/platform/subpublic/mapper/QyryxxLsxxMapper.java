package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.QyryxxLsxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QyryxxLsxxMapper {
    int deleteByPrimaryKey(Integer rylsid);

    int insert(QyryxxLsxx record);

    int insertSelective(QyryxxLsxx record);

    QyryxxLsxx selectByPrimaryKey(Integer rylsid);

    int updateByPrimaryKeySelective(QyryxxLsxx record);

    int updateByPrimaryKey(QyryxxLsxx record);
}