package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.mapper.KyqkMapper;
import com.yuxin.platform.zongzhi.pojo.Kyqk;
import com.yuxin.platform.zongzhi.pojo.KyqkHt;
import com.yuxin.platform.zongzhi.service.KyqkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xk on 2018/3/1.
 */

@Service
public class KyqkServiceImpl implements KyqkService {
    @Autowired
    KyqkMapper KyqkMapper;

    @Override
    public int updateKyqkHt(Kyqk kyqk) {
        int count = KyqkMapper.updateKyqkHt(kyqk);
        return count;
    }

    @Override
    public List<KyqkHt> selectKyqkListHt(Map<String, Object> map) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = (String) map.get("startDate");
        String endDate = (String) map.get("endDate");
        return KyqkMapper.selectKyqkListHt(map);
    }


    @Override
    public List<Kyqk> selectKyqkList(Map<String, Object> map) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = (String) map.get("startDate");
        String endDate = (String) map.get("endDate");
        return KyqkMapper.selectKyqkList(map);
    }

    @Override
    public int insertKyqk(Kyqk kyqk) {
        int count = KyqkMapper.insertKyqk(kyqk);
        return count;
    }


    @Override
    public int deleteByPrimaryKey(Integer kyqkid) {
        Kyqk kyqk = new Kyqk();
        kyqk.setKyqkid(kyqkid);
        kyqk.setScbz((short) 1);
        return KyqkMapper.updateByPrimaryKeySelective(kyqk);
    }

    /**
     * 可疑情况相关数据
     *
     * @return
     */
    @Override
    public List<Kyqk> selectKyqkLists(User user) {
        List<Kyqk> kyqkList = new ArrayList<Kyqk>();
        Map<String, Object> param = new HashMap<String, Object>();
        if (user.getOrganizationId() != null && !"".equals(user.getOrganizationId())) {
            param.put("organizationid", user.getOrganizationId());
            param.put("hylbdm", "01803");
            kyqkList = KyqkMapper.selectKyqkLists(param);
        }
        return kyqkList;
    }
}
