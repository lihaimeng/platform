package com.yuxin.platform.subpublic.mapper;

import com.yuxin.platform.subpublic.pojo.Qyjbxx;
import com.yuxin.platform.subpublic.pojo.QyjbxxExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QyjbxxMapper {
    List<Qyjbxx> selectByExample(QyjbxxExample example);

    int deleteByPrimaryKey(Integer qyid);

    int insert(Qyjbxx record);

    String getDeailyMaxQybm(Qyjbxx record);//获取每一天的注册数量

    int insertSelective(Qyjbxx record);

    Qyjbxx selectByPrimaryKey(Integer qyid);

    Qyjbxx selectByQymc(String qymc);

    /**
     * 根据企业编码查询企业信息
     *
     * @return
     */
    Qyjbxx selectByQybm(String qybm);

    /**
     * 根据企业组织机构代码查询企业信息
     *
     * @return
     */
    List<Integer> selectByGxdwbm(String gxdwbm);

    /**
     * 按区域统计该区域下企业数
     *
     * @param code
     * @return
     */
    int countQyByCode(String code);

    List<Qyjbxx> selectByQyzt(Qyjbxx qyjbxx);

    /**
     * 综治下企业管理查询
     *
     * @return
     */
    List<Qyjbxx> selectByQyzt4zz();

    List<Qyjbxx> selectByCondition(Qyjbxx qyjbxx);

    int updateByPrimaryKeySelective(Qyjbxx record);

    int updateByPrimaryKey(Qyjbxx record);

    List<Qyjbxx> selectByGxdwHylb(Map<String, Object> param);
}