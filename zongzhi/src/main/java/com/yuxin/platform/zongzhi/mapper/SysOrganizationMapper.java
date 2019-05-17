package com.yuxin.platform.zongzhi.mapper;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.zongzhi.pojo.SysOrganization;
import com.yuxin.platform.zongzhi.pojo.SysOrganizationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysOrganizationMapper {
    int countByExample(SysOrganizationExample example);

    int deleteByExample(SysOrganizationExample example);

    int deleteByPrimaryKey(Integer organizationId);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    List<SysOrganization> selectByExample(SysOrganizationExample example);

    SysOrganization selectByPrimaryKey(Integer organizationId);

    int updateByExampleSelective(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByExample(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);

    /*
    根据机构机构简码，查询下级机构列表
     */
    List<Organization> selectByBrevitycode(Integer organizationId);
}