package com.yuxin.platform.zongzhiserver.lock.service;
import com.yuxin.platform.zongzhiserver.lock.dto.SdLockSmithDto;
import com.yuxin.platform.zongzhiserver.lock.model.SdLockSmith;

import java.util.List;


/**
 * Created by jyh on 2018/08/02.
 */
public interface SdLockSmithService{

    int addSdLockSmith(SdLockSmith sdLockSmith) throws Exception;

    List<SdLockSmith> findSdLockSmithList(SdLockSmithDto sdLockSmithDto);

    SdLockSmith findSdLockSmithById(int id);
}
