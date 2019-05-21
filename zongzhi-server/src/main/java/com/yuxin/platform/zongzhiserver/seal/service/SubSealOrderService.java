package com.yuxin.platform.zongzhiserver.seal.service;

import com.yuxin.platform.common.core.Service;
import com.yuxin.platform.common.dto.SubSealOrderRequestDto;
import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealOrderDto;

import java.util.List;


/**
 * Created by jyh on 2018/05/14.
 */
public interface SubSealOrderService extends Service<SubSealOrder> {

    /**
     * 条件查询印章信息
     *
     * @param
     * @param subSealInfoDto
     * @return
     */
    List<SubSealOrder> selectSealOrderByParams(SubSealOrderDto subSealInfoDto);

    /**
     * 条件查询印章信息
     *
     * @param
     * @param
     * @return
     */

    List<SubSealOrder> SelectSealxxDetails(String ddh);


    int addSealOlder(SubSealOrderRequestDto request) throws Exception;

}
