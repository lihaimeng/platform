package com.yuxin.platform.subpublic.service.impl;

import com.yuxin.platform.subpublic.mapper.JfsbxxMapper;
import com.yuxin.platform.subpublic.pojo.Jfsbxx;
import com.yuxin.platform.subpublic.service.JfsbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JfsbxxServiceImpl implements JfsbxxService {

    @Autowired
    private JfsbxxMapper jfsbxxMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Integer qyid) {
        return jfsbxxMapper.deleteByPrimaryKey(qyid);
    }

    @Transactional
    @Override
    public int insert(Jfsbxx record) {
        return jfsbxxMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(Jfsbxx record) {
        return jfsbxxMapper.insertSelective(record);
    }

    @Override
    public Jfsbxx selectByPrimaryKey(Integer qyid) {
        return jfsbxxMapper.selectByPrimaryKey(qyid);
    }

    @Override
    public List<Jfsbxx> selectJfsbxx(Integer qyid) {
        return jfsbxxMapper.selectJfsbxx(qyid);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Jfsbxx record) {
        return jfsbxxMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Jfsbxx record) {
        return jfsbxxMapper.updateByPrimaryKey(record);
    }
}
