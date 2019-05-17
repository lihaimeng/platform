package com.yuxin.platform.subpublic.service.impl;

import com.yuxin.platform.subpublic.mapper.BaryxxMapper;
import com.yuxin.platform.subpublic.pojo.Baryxx;
import com.yuxin.platform.subpublic.service.BaryxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaryxxServiceImpl implements BaryxxService {

    @Autowired
    private BaryxxMapper baryxxMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Integer qyid) {
        return baryxxMapper.deleteByPrimaryKey(qyid);
    }

    @Transactional
    @Override
    public int insert(Baryxx record) {
        return baryxxMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(Baryxx record) {
        return baryxxMapper.insertSelective(record);
    }

    @Override
    public Baryxx selectByPrimaryKey(Integer qyid) {
        return baryxxMapper.selectByPrimaryKey(qyid);
    }

    @Override
    public List<Baryxx> selectByQyid(Integer qyid) {
        return baryxxMapper.selectByQyid(qyid);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Baryxx record) {
        return baryxxMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Baryxx record) {
        return baryxxMapper.updateByPrimaryKey(record);
    }
}
