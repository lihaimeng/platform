package com.yuxin.platform.subpublic.service;

import com.yuxin.platform.subpublic.pojo.Jfsbxx;

import java.util.List;

public interface JfsbxxService {

    int deleteByPrimaryKey(Integer qyid);

    int insert(Jfsbxx record);

    int insertSelective(Jfsbxx record);

    Jfsbxx selectByPrimaryKey(Integer qyid);

    List<Jfsbxx> selectJfsbxx(Integer qyid);

    int updateByPrimaryKeySelective(Jfsbxx record);

    int updateByPrimaryKey(Jfsbxx record);
}
