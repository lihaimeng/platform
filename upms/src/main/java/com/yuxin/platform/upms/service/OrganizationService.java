package com.yuxin.platform.upms.service;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
public interface OrganizationService {

    int insert(Organization record, User user);

    List<Organization> organizationBypid(Integer pid);

    int update(Organization record);

    int delete(Integer id);

    Organization selectByPrimaryKey(Integer organizationId);

    /**
     * 通过机构简码模糊查询
     *
     * @param brevitycode
     * @return
     */
    List<Organization> selectByBrevitycode(String brevitycode);

    /**
     * 通过机构简码模糊查询
     *
     * @return
     */
    List<Organization> selectByBrevitycode4zz(String brevitycode);

    List<Organization> selectUnderOrgbyid(Integer orgid);

}
