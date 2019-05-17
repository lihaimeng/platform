package com.yuxin.platform.subpublic.service;

import com.yuxin.platform.subpublic.pojo.Baryxx;

import java.util.List;

public interface BaryxxService {

    int deleteByPrimaryKey(Integer qyid);

    int insert(Baryxx record);

    int insertSelective(Baryxx record);

    Baryxx selectByPrimaryKey(Integer qyid);

    List<Baryxx> selectByQyid(Integer qyid);

    int updateByPrimaryKeySelective(Baryxx record);

    int updateByPrimaryKey(Baryxx record);
}
