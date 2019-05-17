package com.yuxin.platform.zongzhi.mapper;

import com.yuxin.platform.zongzhi.vo.SubLockInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SubLockInfoMapper {

    /**
     * @param maps
     * @return
     * @author zzd
     * 条件查询开锁信息
     */
    List<SubLockInfoVo> selectLockByParams(Map<String, String> maps);

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

    /**
     * 统计开锁单位数量
     *
     * @return
     */
    int selectByCompanyName();

    /**
     * 统计开锁人员数量
     *
     * @return
     */
    int countCompanyStaff();

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

}