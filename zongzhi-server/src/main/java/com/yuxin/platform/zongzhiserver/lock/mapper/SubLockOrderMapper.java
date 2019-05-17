package com.yuxin.platform.zongzhiserver.lock.mapper;

import com.yuxin.platform.common.core.Mapper;
import com.yuxin.platform.common.model.SubLockOrder;
import com.yuxin.platform.zongzhiserver.lock.dto.SubLockOrderDto;

import java.util.List;
import java.util.Map;

public interface SubLockOrderMapper extends Mapper<SubLockOrder> {
    List<SubLockOrder> searchList(SubLockOrderDto subLockOrderDto);

    int insertSelective(SubLockOrder subLockOrder);

    /**
     * @param maps
     * @return
     * @author zzd
     * 根据管辖单位编码统计区域内开锁信息，包括本区域及所辖区域
     */
    List<Map<String, Object>> selectByGxdwbm(Map<String, Object> maps);

    List<Map<String, Object>> selectByGxdwbm1(Map<String, Object> maps);

    /**
     * @param maps
     * @return
     * @author zzd
     * 根据管辖单位编码分组统计区域内开锁信息
     */
    List<Map<String, Object>> selectGroupByGxdwbm(Map<String, Object> maps);

    /**
     * @param maps
     * @return
     * @author zzd
     * 委托人数量增长情况(最近7天)
     */
    List<Map<String, Object>> selectLastSevenDay(Map<String, Object> maps);

    /**
     * @param maps
     * @return
     * @author zzd
     * 委托人数量增长情况(某年)
     */
    List<Map<String, Object>> selectOfyear(Map<String, Object> maps);

}