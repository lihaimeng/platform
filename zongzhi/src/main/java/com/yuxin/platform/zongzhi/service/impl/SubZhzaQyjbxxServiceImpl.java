package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.zongzhi.mapper.SubZhzaQyjbxxMapper;
import com.yuxin.platform.zongzhi.pojo.SubZhzaQyjbxx;
import com.yuxin.platform.zongzhi.service.SubZhzaQyjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 企业基本信息service实现类
 *
 * @author WJ
 */
@Service
public class SubZhzaQyjbxxServiceImpl implements SubZhzaQyjbxxService {

    @Autowired
    private SubZhzaQyjbxxMapper subZhzaQyjbxxMapper;

    @Override
    public List<SubZhzaQyjbxx> selectSubZhzaQyjbxx() {
        return subZhzaQyjbxxMapper.selectSubZhzaQyjbxx();
    }

    @Override
    public List<SubZhzaQyjbxx> selectSubZhzaQyjbxxByParams(SubZhzaQyjbxx subZhzaQyjbxx) {
        return subZhzaQyjbxxMapper.selectSubZhzaQyjbxxByParams(subZhzaQyjbxx);
    }
}
