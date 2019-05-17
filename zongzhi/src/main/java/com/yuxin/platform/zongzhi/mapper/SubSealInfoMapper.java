package com.yuxin.platform.zongzhi.mapper;

import com.yuxin.platform.zongzhi.dto.SealDto;
import com.yuxin.platform.zongzhi.dto.SubSealInfoDto;
import com.yuxin.platform.zongzhi.pojo.SubSealInfo;
import com.yuxin.platform.zongzhi.vo.SealVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubSealInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubSealInfo record);

    int insertSelective(SubSealInfo record);

    SubSealInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubSealInfo record);

    int updateByPrimaryKey(SubSealInfo record);

    /**
     * 查询所有印章信息ok
     *
     * @return
     */
    List<SubSealInfo> selectSealInfo(SubSealInfo subSealInfo);

    /**
     * 条件查询印章信息ok
     *
     * @param subSealInfoDto
     * @return
     */
    List<SubSealInfo> selectSealInfoByParams(SubSealInfoDto subSealInfoDto);

    /**
     * 查询使用单位数量ok
     *
     * @return
     */
    int selectByCompanyName();

    /**
     * 查询制作单位数量ok
     *
     * @return
     */
    int selectByMarkCompanyName();

    /**
     * 查询印章材质数量ok
     *
     * @return
     */
    int selectBySealMaterial();

    /**
     * 查询印章形状数量ok
     *
     * @return
     */
    int selectBySealShape();

    /**
     * 查询印章中心图案数量ok
     *
     * @return
     */
    int selectBySealPattern();

    /**
     * 统计印章业务数量ok
     *
     * @return
     */
    int countSeal();

    /**
     * 统计每天印章新增业务数量ok
     *
     * @return
     */
    int countSealByDay();

    /**
     * 按月统计使用单位数量ok
     *
     * @return
     */
    List<Integer> countSealCompanyByMonth();

    /**
     * 按月统计制作单位数量ok
     *
     * @return
     */
    List<Integer> countSealMarkCompanyByMonth();

    /**
     * 查询印章日期ok
     *
     * @return
     */
    List<String> selectSealDate();

    /**
     * 按月统计印章数量ok
     *
     * @return
     */
    List<Integer> countSealByMonth();

    /**
     * 根据所属区域查询印章业务数量ok
     *
     * @return
     */
    List<SealVo> selectSealByDominion(SealDto sealDto);

    /**
     * 根据区域查询一周印章业务数量ok
     *
     * @return
     */
    List<SealVo> countSealMsgByDominionWeek(SealDto sealDto);

    /**
     * 根据区域查询一月印章业务数量ok
     *
     * @return
     */
    List<SealVo> countSealMsgByDominionMonth(SealDto sealDto);

    /**
     * 根据区域查询一月印章业务数量ok
     *
     * @return
     */
    List<SealVo> countSealMsgByDominionYear(SealDto sealDto);

    /**
     * 按周统计印章使用单位增量ok
     *
     * @return
     */
    List<SealVo> sealCompanyByWeek(String brevitycode);

    /**
     * 按时间条件统计一周印章使用单位增量ok
     *
     * @return
     */
    List<SealVo> sealCompanyByDateWeek(SealDto sealDto);

    /**
     * 按时间条件统计一个月印章使用单位增量ok
     *
     * @return
     */
    List<SealVo> sealCompanyByDateMonth(SealDto sealDto);

    /**
     * 按时间条件统计一年印章使用单位增量ok
     *
     * @return
     */
    List<SealVo> sealCompanyByDateYear(SealDto sealDto);

    /**
     * 根据印章类型查询印章业务数量ok
     *
     * @return
     */
    List<SealVo> selectSealByType(String brevitycode);

    /**
     * 通过日期按年统计印章信息ok
     *
     * @param sealDto
     * @return
     */
    List<SealVo> selectSealByDateYear(SealDto sealDto);

    /**
     * 通过日期按月统计印章信息ok
     *
     * @param sealDto
     * @return
     */
    List<SealVo> selectSealByDateMonth(SealDto sealDto);

    /**
     * 通过日期按周统计印章信息ok
     *
     * @param sealDto
     * @return
     */
    List<SealVo> selectSealByDateWeek(SealDto sealDto);
}