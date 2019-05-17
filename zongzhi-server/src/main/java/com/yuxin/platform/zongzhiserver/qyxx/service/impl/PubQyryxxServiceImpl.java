package com.yuxin.platform.zongzhiserver.qyxx.service.impl;

import com.yuxin.platform.common.core.AbstractService;
import com.yuxin.platform.zongzhiserver.qyxx.mapper.PubQyryxxMapper;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxx;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxxAndQyjbxx;
import com.yuxin.platform.zongzhiserver.qyxx.service.PubQyryxxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by jyh on 2018/07/05.
 */
@Service
@Transactional
public class PubQyryxxServiceImpl extends AbstractService<PubQyryxx> implements PubQyryxxService {
    @Resource
    private PubQyryxxMapper pubQyryxxMapper;

    @Override
    public List<PubQyryxxAndQyjbxx> getByCondition(PubQyryxxAndQyjbxx pubQyryxxAndQyjbxx) {
        return pubQyryxxMapper.getByCondition(pubQyryxxAndQyjbxx);
    }
}
