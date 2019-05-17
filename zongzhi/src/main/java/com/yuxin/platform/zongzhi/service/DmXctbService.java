package com.yuxin.platform.zongzhi.service;


import com.yuxin.platform.zongzhi.pojo.DmXctb;
import com.yuxin.platform.zongzhi.pojo.DmXctbExample;
import com.yuxin.platform.zongzhi.pojo.SysAttachments;

import java.util.List;

public interface DmXctbService {

    int deleteByPrimaryKey(Integer tbid);

    int insert(DmXctb record);

    int insertSelective(DmXctb record);

    DmXctb selectByPrimaryKey(Integer tbid);

    List<DmXctb> selectByExample(DmXctbExample example);

    int updateByPrimaryKeySelective(DmXctb record);

    int updateByPrimaryKey(DmXctb record);

    int countByExample(DmXctbExample example);

    DmXctb selectLastid(Integer id);
}
