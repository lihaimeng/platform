package com.yuxin.platform.zongzhiserver.qyxx.service;

import com.yuxin.platform.common.core.Service;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxx;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxxAndQyjbxx;

import java.util.List;


/**
 * Created by jyh on 2018/07/05.
 */
public interface PubQyryxxService extends Service<PubQyryxx> {
    List<PubQyryxxAndQyjbxx> getByCondition(PubQyryxxAndQyjbxx pubQyryxxAndQyjbxx);
}
