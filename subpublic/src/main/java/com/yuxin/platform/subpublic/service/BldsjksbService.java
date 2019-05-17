package com.yuxin.platform.subpublic.service;

import com.yuxin.platform.subpublic.pojo.Bldsjksb;

import java.util.List;

public interface BldsjksbService {

    int deleteByPrimaryKey(Integer qyid);

    int insert(Bldsjksb record);

    int insertSelective(Bldsjksb record);

    Bldsjksb selectByPrimaryKey(Integer qyid);

    List<Bldsjksb> selectBldsjksb(Integer qyid);

    int updateByPrimaryKeySelective(Bldsjksb record);

    int updateByPrimaryKey(Bldsjksb record);
}
