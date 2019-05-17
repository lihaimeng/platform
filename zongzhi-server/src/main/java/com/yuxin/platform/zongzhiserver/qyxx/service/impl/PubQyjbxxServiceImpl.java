package com.yuxin.platform.zongzhiserver.qyxx.service.impl;

import com.yuxin.platform.common.core.AbstractService;
import com.yuxin.platform.zongzhiserver.qyxx.mapper.PubQyjbxxMapper;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyjbxx;
import com.yuxin.platform.zongzhiserver.qyxx.service.PubQyjbxxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by jyh on 2018/07/05.
 */
@Service
@Transactional
public class PubQyjbxxServiceImpl extends AbstractService<PubQyjbxx> implements PubQyjbxxService {
    @Resource
    private PubQyjbxxMapper pubQyjbxxMapper;

    @Override
    public List<PubQyjbxx> getByCondition(PubQyjbxx pubQyjbxx) {
        return pubQyjbxxMapper.getByCondition(pubQyjbxx);
    }
}
