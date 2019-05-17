package com.yuxin.platform.zongzhi.mapper;

import com.yuxin.platform.zongzhi.pojo.SubZhzaQyjbxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubZhzaQyjbxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubZhzaQyjbxx record);

    int insertSelective(SubZhzaQyjbxx record);

    SubZhzaQyjbxx selectByPrimaryKey(Integer id);

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

    int updateByPrimaryKeySelective(SubZhzaQyjbxx record);

    int updateByPrimaryKey(SubZhzaQyjbxx record);
}