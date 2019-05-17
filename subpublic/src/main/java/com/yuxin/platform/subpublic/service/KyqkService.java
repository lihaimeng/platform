package com.yuxin.platform.subpublic.service;

import com.yuxin.platform.subpublic.pojo.Kyqk;

import java.util.List;
import java.util.Map;

/**
 * Created by Xk on 2018/3/1.
 */
public interface KyqkService {

    List<Kyqk> selectKyqkList(Map<String, Object> map);

    int insertKyqk(Kyqk kyqk);

    int updateKyqk(Kyqk kyqk);

    int deleteByPrimaryKey(Integer kyqkid);
}
