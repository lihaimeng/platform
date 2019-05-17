package com.yuxin.platform.zongzhi.service;

import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.dto.SealDto;
import com.yuxin.platform.zongzhi.dto.SubSealInfoDto;
import com.yuxin.platform.zongzhi.pojo.SubSealInfo;

import java.util.List;
import java.util.Map;

/**
 * 印章相关信息service
 *
 * @author wj
 */
public interface SubSealInfoService {

    /**
     * 查询所有印章信息
     *
     * @param user
     * @return
     */
    List<SubSealInfo> selectSealInfo(User user);

    /**
     * 条件查询印章信息
     *
     * @param subSealInfoDto
     * @param user
     * @return
     */
    List<SubSealInfo> selectSealInfoByParams(SubSealInfoDto subSealInfoDto, User user);

    /**
     * 统计使用单位和制作单位数量
     *
     * @return
     */
    Map<String, Object> countCompany();

    /**
     * 统计印章材质，印章形状，中心图案数量
     *
     * @return
     */
    Map<String, Object> countSeal();

    /**
     * 按月统计单位数量
     *
     * @return
     */
    Map<String, Object> countSealCompanyByMonth();

    /**
     * 按月统计单位数量
     *
     * @return
     */
    Map<String, Object> countSealByMonth();

    /**
     * 根据所属区域查询印章业务数量
     *
     * @return
     */
    Map<String, Object> selectSealMsg(User user);

    /**
     * 管辖区域统计印章信息
     *
     * @param sealDto
     * @return
     */
    Map<String, Object> getSealMsgByDominion(SealDto sealDto, User user);

    /**
     * 印章类型统计印章信息
     *
     * @param sealDto
     * @return
     */
    Map<String, Object> getSealMsgBySealType(SealDto sealDto, User user);

    /**
     * 条件查询印章信息
     *
     * @param sealDto
     * @return
     */
    Map<String, Object> getSealCompanyByTime(SealDto sealDto, User user);
}
