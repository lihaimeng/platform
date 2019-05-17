package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.upms.mapper.OrganizationMapper;
import com.yuxin.platform.upms.mapper.RoleMapper;
import com.yuxin.platform.upms.mapper.UserRoleMapper;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.mapper.DmXctbMapper;
import com.yuxin.platform.zongzhi.mapper.KyqkMapper;
import com.yuxin.platform.zongzhi.mapper.SubLockInfoMapper;
import com.yuxin.platform.zongzhi.mapper.SubSealInfoMapper;
import com.yuxin.platform.zongzhi.pojo.DmXctb;
import com.yuxin.platform.zongzhi.pojo.KyqkHt;
import com.yuxin.platform.zongzhi.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 综治首页查询接口实现类
 *
 * @author wj
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private SubSealInfoMapper subSealInfoMapper;

    @Autowired
    private SubLockInfoMapper subLockInfoMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private DmXctbMapper dmXctbMapper;

    @Autowired
    private KyqkMapper kyqkMapper;

    @Override
    public int countSealCompany() {
        int selectByCompanyName = subSealInfoMapper.selectByCompanyName();
        int selectByMarkCompanyName = subSealInfoMapper.selectByMarkCompanyName();
        int sealCompanyNum = selectByCompanyName + selectByMarkCompanyName;
        return sealCompanyNum;
    }

    @Override
    public int countSeal() {
        return subSealInfoMapper.countSeal();
    }

    @Override
    public int countSealByDay() {
        return subSealInfoMapper.countSealByDay();
    }

    @Override
    public int countLock() {
        return subLockInfoMapper.countLock();
    }

    @Override
    public int countLockByDay() {
        return subLockInfoMapper.countLockByDay();
    }

    @Override
    public int countSealCompanyStaff() {
        int i = countSealCompany();
        int num = 0;
        if (i > 0) {
            num = i * 5;
        } else {
            int selectByCompanyName = subSealInfoMapper.selectByCompanyName();
            int selectByMarkCompanyName = subSealInfoMapper.selectByMarkCompanyName();
            num = (selectByCompanyName + selectByMarkCompanyName) * 5;
        }
        return num;
    }

    @Override
    public int countLockCompany() {
        int countCompanyName = subLockInfoMapper.selectByCompanyName();
        return countCompanyName;
    }

    @Override
    public int countLockCompanyStaff() {
        int companyStaff = subLockInfoMapper.countCompanyStaff();
        return companyStaff;
    }

    @Override
    public Map<String, Object> getUserMsg(User user) {
        Map<String, Object> map = new HashMap<>();
        List<DmXctb> dmXctbs = dmXctbMapper.selectXctg();
        List<KyqkHt> kyqkHts = kyqkMapper.selectKyqk();
        map.put("xctg", dmXctbs);
        map.put("kyqk", kyqkHts);
        return map;
    }


}
