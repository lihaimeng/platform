package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.zongzhi.mapper.SysOrganizationMapper;
import com.yuxin.platform.zongzhi.pojo.SysOrganization;
import com.yuxin.platform.zongzhi.pojo.SysOrganizationExample;
import com.yuxin.platform.zongzhi.service.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {
    @Autowired
    private SysOrganizationMapper SysOrganizationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return SysOrganizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysOrganization record) {
        return 0;
    }

    @Override
    public int insertSelective(SysOrganization record) {
        return SysOrganizationMapper.insertSelective(record);
    }

    @Override
    public SysOrganization selectByPrimaryKey(Integer id) {
        return SysOrganizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysOrganization> selectByExample(SysOrganizationExample example) {
        return SysOrganizationMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysOrganization record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysOrganization record) {
        return SysOrganizationMapper.updateByPrimaryKey(record);
    }

    /*
    根据机构机构简码，查询下级机构列表
     */
    @Override
    public List<Organization> selectByBrevitycode(Integer organizationId) {
        return SysOrganizationMapper.selectByBrevitycode(organizationId);
    }
}
