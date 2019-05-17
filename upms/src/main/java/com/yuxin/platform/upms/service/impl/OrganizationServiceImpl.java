package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.OrganizationMapper;
import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Transactional
    @Override
    public int insert(Organization record, User user) {
        Integer organizationId = user.getOrganizationId();
        if (organizationId != 0) {
            Organization organization = organizationMapper.selectByPrimaryKey(organizationId);
            String brevitycode = organization.getBrevitycode();
            String code = record.getCode();
            if (record.getPid() > organization.getPid()) {
                if (code.indexOf(brevitycode) != -1) {
                    if (Integer.parseInt(code) > Integer.parseInt(brevitycode)) {
                        return getInsertOrganizationMsg(record);
                    }
                    return -2;
                }
                return -2;
            }
            return -3;
        } else {
            return getInsertOrganizationMsg(record);
        }
    }

    public int getInsertOrganizationMsg(Organization organization) {
        String code = organization.getCode();
        List<Organization> organizations = organizationMapper.selectByObject(organization);
        if (organizations.size() == 0) {
            Date date = new Date();
            organization.setAddtime(date);
            if (code.indexOf("0000") != -1) {
                code = code.substring(0, 2);
            } else if (code.indexOf("00") != -1) {
                code = code.substring(0, 4);
            }
            organization.setBrevitycode(code);
            int insertSelective = organizationMapper.insertSelective(organization);
            if (insertSelective > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public List<Organization> organizationBypid(Integer pid) {
        // TODO Auto-generated method stub
        return organizationMapper.selectByPid(pid);
    }

    @Transactional
    @Override
    public int update(Organization record) {
        List<Organization> organizations = organizationMapper.selectByObject(record);
        if (organizations.size() == 0) {
            int i = organizationMapper.updateByPrimaryKeySelective(record);
            if (i > 0) {
                return i;
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Transactional
    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        List<Organization> list = organizationMapper.selectByPid(id);
        if (list.size() > 0) {
            return 0;
        }
        return organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Organization selectByPrimaryKey(Integer organizationId) {
        // TODO Auto-generated method stub
        return organizationMapper.selectByPrimaryKey(organizationId);
    }

    @Override
    public List<Organization> selectByBrevitycode(String brevitycode) {
        return organizationMapper.selectByBrevitycode(brevitycode);
    }

    @Override
    public List<Organization> selectByBrevitycode4zz(String brevitycode) {
        return organizationMapper.selectByBrevitycode4zz(brevitycode);
    }

    @Override
    public List<Organization> selectUnderOrgbyid(Integer orgid) {
        return organizationMapper.selectUnderOrgbyid(orgid);
    }
}
