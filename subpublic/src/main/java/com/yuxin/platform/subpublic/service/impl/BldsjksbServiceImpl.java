package com.yuxin.platform.subpublic.service.impl;

import com.yuxin.platform.subpublic.mapper.BldsjksbMapper;
import com.yuxin.platform.subpublic.pojo.Bldsjksb;
import com.yuxin.platform.subpublic.service.BldsjksbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BldsjksbServiceImpl implements BldsjksbService {

    @Autowired
    private BldsjksbMapper bldsjksbMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Integer qyid) {
        return bldsjksbMapper.deleteByPrimaryKey(qyid);
    }

    @Transactional
    @Override
    public int insert(Bldsjksb record) {
        return bldsjksbMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(Bldsjksb record) {
        return bldsjksbMapper.insertSelective(record);
    }

    @Override
    public Bldsjksb selectByPrimaryKey(Integer qyid) {
        return bldsjksbMapper.selectByPrimaryKey(qyid);
    }

    @Override
    public List<Bldsjksb> selectBldsjksb(Integer qyid) {
        return bldsjksbMapper.selectBldsjksb(qyid);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Bldsjksb record) {
        return bldsjksbMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Bldsjksb record) {
        return bldsjksbMapper.updateByPrimaryKey(record);
    }
}
