package com.yuxin.platform.zongzhi.service;

import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.pojo.Kyqk;
import com.yuxin.platform.zongzhi.pojo.KyqkHt;

import java.util.List;
import java.util.Map;

/**
 * Created by Xk on 2018/3/1.
 */
public interface KyqkService {
    int updateKyqkHt(Kyqk kyqk);

    List<KyqkHt> selectKyqkListHt(Map<String, Object> map);

    List<Kyqk> selectKyqkList(Map<String, Object> map);

    int insertKyqk(Kyqk kyqk);

    int deleteByPrimaryKey(Integer kyqkid);

    /**
     * 可疑情况相关数据
     *
     * @return
     */
    List<Kyqk> selectKyqkLists(User user);
}
