package com.yuxin.platform.zongzhiserver.lock.service;

import com.yuxin.platform.common.core.Service;
import com.yuxin.platform.common.model.SubLockOrder;
import com.yuxin.platform.zongzhiserver.lock.dto.SubLockOrderDto;

import java.util.List;


/**
 * Created by jyh on 2018/05/31.
 */
public interface SubLockOrderService extends Service<SubLockOrder> {
    int addLockOrder(SubLockOrder subLockOrder) throws Exception;
    int insert(SubLockOrder subLockOrder);
    List<SubLockOrder> searchList(SubLockOrderDto subLockOrderDto);
}
