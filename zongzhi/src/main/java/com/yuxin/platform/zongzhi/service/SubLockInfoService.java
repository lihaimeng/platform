package com.yuxin.platform.zongzhi.service;

import com.yuxin.platform.zongzhi.vo.SubLockInfoVo;

import java.util.List;
import java.util.Map;

/**
 * 印章相关信息service
 *
 * @author wj
 */
public interface SubLockInfoService {

    /**
     * @param maps
     * @return
     * @author zzd
     * 条件查询开锁信息
     */
    List<SubLockInfoVo> selectLockByParams(Map<String, String> maps);

}
