/**
 * @author zzd
 * <p>
 * 2018年2月28日
 */
package com.yuxin.platform.subpublic.service;

import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.subpublic.pojo.Qyryxx;
import com.yuxin.platform.subpublic.vo.QyryVo;
import com.yuxin.platform.upms.pojo.Role;
import com.yuxin.platform.upms.pojo.User;

import java.util.List;
import java.util.Map;

public interface CyryService {
    int deleteByPrimaryKey(Integer ryid);

    int insert(Qyryxx record, Role role, User user);

    int insertSelective(Qyryxx record);

    Qyryxx selectByPrimaryKey(Integer ryid);

    Qyryxx selectByCyrybh(String cyrybh);

    List<QyryVo> selectQyryxxs(Map<String, Object> map, User user);

    List<QyryVo> selectQyryxxsForDaily(Map<String, Object> map);

    int insertAttach(Attachments attachments, String userName);

    int updateAttach(Attachments attachments, String userName);

    int updateByPrimaryKeySelective(Qyryxx record, Role role);

    /**
     * 同步印章系统从业人员信息
     * @param record
     */
    int insertCyryBySeal(Qyryxx record);

}


