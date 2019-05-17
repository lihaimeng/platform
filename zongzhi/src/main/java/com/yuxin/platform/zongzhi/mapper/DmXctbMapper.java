package com.yuxin.platform.zongzhi.mapper;


import com.yuxin.platform.zongzhi.pojo.DmXctb;
import com.yuxin.platform.zongzhi.pojo.DmXctbExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DmXctbMapper {
    int countByExample(DmXctbExample example);

    int deleteByExample(DmXctbExample example);

    int deleteByPrimaryKey(Integer tbid);

    int insert(DmXctb record);

    int insertSelective(DmXctb record);

    List<DmXctb> selectByExample(DmXctbExample example);

    DmXctb selectByPrimaryKey(Integer tbid);

    int updateByExampleSelective(@Param("record") DmXctb record, @Param("example") DmXctbExample example);

    int updateByExample(@Param("record") DmXctb record, @Param("example") DmXctbExample example);

    int updateByPrimaryKeySelective(DmXctb record);

    int updateByPrimaryKey(DmXctb record);

    DmXctb selectLastid(Integer id);

    /**
     * 查询协查通告信息
     *
     * @return
     */
    List<DmXctb> selectXctg();
}