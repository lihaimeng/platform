package com.yuxin.platform.zongzhiserver.seal.service;

import com.yuxin.platform.common.core.Service;
import com.yuxin.platform.common.model.SubSealSydw;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSydwDto;

import java.util.List;


/**
 * Created by jyh on 2018/05/14.
 */
public interface SubSealSydwService extends Service<SubSealSydw> {
    /**
     * 条件查询印章信息
     *
     * @param
     * @param subSealSydwDto
     * @return
     */
    List<SubSealSydw> selectSealSydwByParams(SubSealSydwDto subSealSydwDto);

    int addSubSealSydw(SubSealSydw subSealSydw) throws Exception;
}
