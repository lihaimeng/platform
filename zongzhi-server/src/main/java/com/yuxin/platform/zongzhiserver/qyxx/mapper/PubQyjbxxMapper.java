package com.yuxin.platform.zongzhiserver.qyxx.mapper;

import com.yuxin.platform.common.core.Mapper;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyjbxx;

import java.util.List;

public interface PubQyjbxxMapper extends Mapper<PubQyjbxx> {
    List<PubQyjbxx> getByCondition(PubQyjbxx pubQyjbxx);
}