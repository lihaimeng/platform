package com.yuxin.platform.zongzhiserver.seal.mapper;

import com.yuxin.platform.common.core.Mapper;
import com.yuxin.platform.common.model.SubSealSydw;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSydwDto;

import java.util.List;

public interface SubSealSydwMapper extends Mapper<SubSealSydw> {
    /**
     * 条件查询印章业务信息
     *
     * @param subSealSydwDto
     * @return
     */
    List<SubSealSydw> selectSealSydwByParams(SubSealSydwDto subSealSydwDto);
}