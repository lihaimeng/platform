package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.zongzhi.mapper.DmXctbMapper;
import com.yuxin.platform.zongzhi.pojo.DmXctb;
import com.yuxin.platform.zongzhi.pojo.DmXctbExample;
import com.yuxin.platform.zongzhi.service.DmXctbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmXctbServiceImpl implements DmXctbService {
    @Autowired
    private DmXctbMapper dmXctbMapper;

    @Override
    public int deleteByPrimaryKey(Integer tbid) {
        return dmXctbMapper.deleteByPrimaryKey(tbid);
    }

    @Override
    public int insert(DmXctb record) {
        return 0;
    }

    @Override
    public int insertSelective(DmXctb record) {
        return dmXctbMapper.insertSelective(record);
    }

    @Override
    public DmXctb selectByPrimaryKey(Integer tbid) {
        return dmXctbMapper.selectByPrimaryKey(tbid);
    }

    @Override
    public List<DmXctb> selectByExample(DmXctbExample example) {
        return dmXctbMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(DmXctb record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DmXctb record) {
        return dmXctbMapper.updateByPrimaryKey(record);
    }

    @Override
    public int countByExample(DmXctbExample example) {
        return dmXctbMapper.countByExample(example);
    }

    @Override
    public DmXctb selectLastid(Integer id) {
        return dmXctbMapper.selectLastid(id);
    }
}
