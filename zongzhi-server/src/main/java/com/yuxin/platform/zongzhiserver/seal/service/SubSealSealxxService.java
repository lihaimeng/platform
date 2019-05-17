package com.yuxin.platform.zongzhiserver.seal.service;

import com.yuxin.platform.common.core.Service;
import com.yuxin.platform.common.dto.SubSealOrderRequestDto;
import com.yuxin.platform.common.model.SubSealSealxx;
import com.yuxin.platform.zongzhiserver.seal.dto.ResultSubSealOrderDto;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSealxxDto;

import java.util.List;


/**
 * Created by jyh on 2018/05/14.
 */
public interface SubSealSealxxService extends Service<SubSealSealxx> {
    /**
     * 条件查询印章信息
     *
     * @param
     * @param subSealSealxxDto
     * @return
     */
    List<SubSealSealxx> selectSealSealxxByParams(SubSealSealxxDto subSealSealxxDto);


    /**
     * 条件查询印章信息
     *
     * @param
     * @param
     * @return
     */
    List<ResultSubSealOrderDto> sealxxAndSubSealOrderDetails(SubSealSealxxDto subSealSealxxDto);

    int addSubSealSealxx(List<SubSealSealxx> subSealSealxxList) throws Exception;

}
