package com.yuxin.platform.upms.service;

import com.yuxin.platform.upms.pojo.Param;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
public interface ParamService {

    List<Param> getAllParam();

    Param selectByCode(String code);

    int insert(Param param);

    int update(Param param);

    int delete(Integer id);

}
