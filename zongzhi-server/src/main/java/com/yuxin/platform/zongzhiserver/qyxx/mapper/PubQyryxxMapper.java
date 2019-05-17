package com.yuxin.platform.zongzhiserver.qyxx.mapper;

import com.yuxin.platform.common.core.Mapper;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxx;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxxAndQyjbxx;

import java.util.List;

public interface PubQyryxxMapper extends Mapper<PubQyryxx> {
    List<PubQyryxxAndQyjbxx> getByCondition(PubQyryxxAndQyjbxx pubQyryxxAndQyjbxx);
}