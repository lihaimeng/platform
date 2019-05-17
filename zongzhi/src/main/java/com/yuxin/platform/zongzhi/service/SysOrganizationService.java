package com.yuxin.platform.zongzhi.service;


import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.zongzhi.pojo.SysOrganization;
import com.yuxin.platform.zongzhi.pojo.SysOrganizationExample;

import java.util.List;

public interface SysOrganizationService {

    int deleteByPrimaryKey(Integer id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(Integer id);

    List<SysOrganization> selectByExample(SysOrganizationExample example);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);

    /*
    根据机构机构简码，查询下级机构列表
   */
    List<Organization> selectByBrevitycode(Integer organizationId);
}
