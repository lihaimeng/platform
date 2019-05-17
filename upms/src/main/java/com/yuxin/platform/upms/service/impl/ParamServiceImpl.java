package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.ParamMapper;
import com.yuxin.platform.upms.pojo.Param;
import com.yuxin.platform.upms.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    private ParamMapper paramMapper;

    @Override
    public List<Param> getAllParam() {
        // TODO Auto-generated method stub
        return paramMapper.selectParam();
    }

    @Override
    public Param selectByCode(String code) {
        // TODO Auto-generated method stub
        return paramMapper.selectByCode(code);
    }

    @Transactional
    @Override
    public int insert(Param param) {
        // TODO Auto-generated method stub
        return paramMapper.insertSelective(param);
    }

    @Transactional
    @Override
    public int update(Param param) {
        // TODO Auto-generated method stub
        return paramMapper.updateByPrimaryKeySelective(param);
    }

    @Transactional
    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return paramMapper.deleteByPrimaryKey(id);
    }

}
