package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.QyjbxxLs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QyjbxxLsMapper {
    int deleteByPrimaryKey(Integer qyid);

    int insert(QyjbxxLs record);

    int insertSelective(QyjbxxLs record);

    QyjbxxLs selectByPrimaryKey(Integer qyid);

    int updateByPrimaryKeySelective(QyjbxxLs record);

    int updateByPrimaryKey(QyjbxxLs record);
}