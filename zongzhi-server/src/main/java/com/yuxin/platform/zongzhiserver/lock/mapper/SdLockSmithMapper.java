package com.yuxin.platform.zongzhiserver.lock.mapper;

import com.yuxin.platform.zongzhiserver.lock.dto.SdLockSmithDto;
import com.yuxin.platform.zongzhiserver.lock.model.SdLockSmith;

import java.util.List;

public interface SdLockSmithMapper{
    int insertSelective(SdLockSmith sdLockSmith);

    SdLockSmith findSdLocksmithByIdcard(String idcard);

    List<SdLockSmith> findSdLockSmithList(SdLockSmithDto sdLockSmithDto);

    SdLockSmith findSdLockSmithById(int id);
}