package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface OrganizationMapper {

    int deleteByPrimaryKey(Integer organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer organizationId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    /**
     * 通过pid查询机构信息
     *
     * @param pid
     * @return
     */
    List<Organization> selectByPid(Integer pid);

    /**
     * 通过机构名查询
     *
     * @param name
     * @return
     */
    List<Organization> selectByObject(Organization organization);

    /**
     * 通过机构简码模糊查询
     *
     * @param brevitycode
     * @return
     */
    List<Organization> selectByBrevitycode(String brevitycode);

    /**
     * 通过机构简码查询
     *
     * @param brevitycode
     * @return
     */
    Organization isNullByBrevitycode(String brevitycode);

    /**
     * 通过机构编码查询
     *
     * @param code
     * @return
     */
    Organization selectByCode(String code);

    /**
     * 通过机构简码模糊查询,获取下一级管辖区域
     *
     * @param brevitycode
     * @return
     */
    List<Map<String, Object>> selectByBrevitycode1(Map<String, Object> map);

    /**
     * 通过机构简码模糊查询
     *
     * @return
     */
    List<Organization> selectByBrevitycode4zz(String brevitycode);

    List<Organization> selectUnderOrgbyid(Integer orgid);
}