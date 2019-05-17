package com.yuxin.platform.zongzhi.service;

import com.yuxin.platform.upms.pojo.User;

import java.util.List;
import java.util.Map;

public interface IndexLockService {

    /**
     * 地区业务数据情况
     *
     * @return
     */
    List<Map<String, Object>> getCountsOfOrganization(User user, Map<String, Object> maps);

    /**
     * 开锁类型占比情况
     *
     * @return
     */
    List<Map<String, Object>> getCountsOfKslx(User user, Map<String, Object> param);

    /**
     * 委托人数量增长情况
     *
     * @return
     */
    List<Map<String, Object>> getCountsOfWtr(User user, Map<String, Object> maps);

    /**
     * 开锁企业分布情况
     *
     * @return
     */
    List<Map<String, Object>> getCountsOfQyfb(User user, Map<String, Object> maps);


}
