package com.yuxin.platform.zongzhi.service;

import com.yuxin.platform.upms.pojo.User;

import java.util.Map;

/**
 * 综治首页查询接口
 *
 * @author wj
 */
public interface IndexService {
    /**
     * 统计印章行业所有单位数量
     *
     * @return
     */
    int countSealCompany();

    /**
     * 统计印章业务数量
     *
     * @return
     */
    int countSeal();

    /**
     * 统计每天印章新增业务数量
     *
     * @return
     */
    int countSealByDay();

    /**
     * 统计锁业业务数量
     *
     * @return
     */
    int countLock();

    /**
     * 统计锁业每日新增业务数量
     *
     * @return
     */
    int countLockByDay();

    /**
     * 统计印章行业所有人员数量
     *
     * @return
     */
    int countSealCompanyStaff();

    /**
     * 统计锁业行业所有单位数量
     *
     * @return
     */
    int countLockCompany();

    /**
     * 统计锁业行业所有人员数量
     *
     * @return
     */
    int countLockCompanyStaff();

    Map<String, Object> getUserMsg(User user);


}
