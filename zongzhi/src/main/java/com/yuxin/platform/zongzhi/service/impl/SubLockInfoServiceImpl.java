package com.yuxin.platform.zongzhi.service.impl;


import com.yuxin.platform.zongzhi.mapper.SubLockInfoMapper;
import com.yuxin.platform.zongzhi.service.SubLockInfoService;
import com.yuxin.platform.zongzhi.vo.SubLockInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 印章相关信息service实现类
 *
 * @author wj
 */
@Service
public class SubLockInfoServiceImpl implements SubLockInfoService {

    @Autowired
    private SubLockInfoMapper subLockInfoMapper;

    /**
     * 条件查询开锁信息
     *
     * @param maps
     * @return
     */
    @Override
    public List<SubLockInfoVo> selectLockByParams(Map<String, String> maps) {
        /*if (!maps.get("unlockedBeginTime").equals("")) {
            String unlockedBeginTime = datestampToString(maps.get("unlockedBeginTime"));
            maps.put("unlockedBeginTime", unlockedBeginTime);
        }
        if (!maps.get("unlockedEndTime").equals("")) {
            String unlockedEndTime = datestampToString(maps.get("unlockedEndTime"));
            maps.put("unlockedEndTime", unlockedEndTime);
        }*/
        return subLockInfoMapper.selectLockByParams(maps);
    }

    public String datestampToString(String datestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateOld = new Date(Long.valueOf(datestamp));
        String time = dateFormat.format(dateOld);
        System.out.println(time);
        return time;
    }
}
