package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.QyryZp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QyryZpMapper {
    int deleteByPrimaryKey(Integer qyid);

    int insert(QyryZp record);

    int insertSelective(QyryZp record);

    QyryZp selectByPrimaryKey(Integer qyid);

    int updateByPrimaryKeySelective(QyryZp record);

    int updateByPrimaryKeyWithBLOBs(QyryZp record);

    int updateByPrimaryKey(QyryZp record);
}