package com.yuxin.platform.zongzhiserver.qyxx.service;

import com.yuxin.platform.common.core.Service;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyjbxx;

import java.util.List;


/**
 * Created by jyh on 2018/07/05.
 */
public interface PubQyjbxxService extends Service<PubQyjbxx> {
    List<PubQyjbxx> getByCondition(PubQyjbxx pubQyjbxx);

}
