package com.yuxin.platform.zongzhi.service;

import com.yuxin.platform.zongzhi.pojo.SubZhzaQyjbxx;

import java.util.List;

/**
 * 综治企业基本信息service
 *
 * @author wj
 */
public interface SubZhzaQyjbxxService {
    /**
     * 获取所有企业基本信息
     *
     * @return
     */
    List<SubZhzaQyjbxx> selectSubZhzaQyjbxx();

    /**
     * 条件查询企业基本信息
     *
     * @param subZhzaQyjbxx
     * @return
     */
    List<SubZhzaQyjbxx> selectSubZhzaQyjbxxByParams(SubZhzaQyjbxx subZhzaQyjbxx);
}
