package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.Qyryxx;
import com.yuxin.platform.subpublic.vo.QyryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QyryxxMapper {
    int deleteByPrimaryKey(Integer qyid);

    int delete(Integer id, String tableName);

    int insert(Qyryxx record);

    int insertSelective(Qyryxx record);

    String getDeailyMaxCyrybm(Qyryxx record);

    Qyryxx selectByPrimaryKey(Integer qyid);

    Qyryxx selectByRybh(String cyrybh);

    List<QyryVo> selectQyryxxs(Map<String, Object> map);

    /**
     * 统计qyid统计人员数量
     *
     * @param qyid
     * @return
     */
    String getMaxCyrybm(int qyid);

    List<QyryVo> selectQyryxxsForDaily(Map<String, Object> map);

    int updateByPrimaryKeySelective(Qyryxx record);

    int updateByPrimaryKey(Qyryxx record);

    /**
     * 通过企业id查询企业员工信息
     *
     * @param qyid
     * @return
     */
    List<Qyryxx> selectByQyid(Integer qyid);
}