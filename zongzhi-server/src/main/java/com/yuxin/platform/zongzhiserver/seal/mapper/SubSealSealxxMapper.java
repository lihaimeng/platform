package com.yuxin.platform.zongzhiserver.seal.mapper;

import com.yuxin.platform.common.core.Mapper;
import com.yuxin.platform.common.model.SubSealSealxx;
import com.yuxin.platform.zongzhiserver.seal.dto.ResultSubSealOrderDto;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSealxxDto;

import java.util.List;

public interface SubSealSealxxMapper extends Mapper<SubSealSealxx> {
    /**
     * 条件查询印章业务信息
     *
     * @param subSealSealxxDto
     * @return
     */
    List<SubSealSealxx> selectSealSealxxByParams(SubSealSealxxDto subSealSealxxDto);


    /**
     * 条件查询印章业务信息
     *
     * @param
     * @return
     */
    List<ResultSubSealOrderDto> sealxxAndSubSealOrderDetails(SubSealSealxxDto subSealSealxxDto);

}