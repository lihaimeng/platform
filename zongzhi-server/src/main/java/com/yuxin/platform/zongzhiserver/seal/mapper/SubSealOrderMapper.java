package com.yuxin.platform.zongzhiserver.seal.mapper;

import com.yuxin.platform.common.core.Mapper;
import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealOrderDto;

import java.util.List;

public interface SubSealOrderMapper extends Mapper<SubSealOrder> {


    /**
     * 条件查询印章业务信息
     *
     * @param subSealOrderDto
     * @return
     */
    List<SubSealOrder> selectSealOrderByParams(SubSealOrderDto subSealOrderDto);


    /**
     * 条件查询印章业务信息
     *
     * @param
     * @return
     */
    List<SubSealOrder> SelectSealxxDetails(String ddh);

}