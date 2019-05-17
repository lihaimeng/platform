package com.yuxin.platform.zongzhi.mapper;

import com.yuxin.platform.zongzhi.pojo.Kyqk;
import com.yuxin.platform.zongzhi.pojo.KyqkHt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Xk on 2018/3/1.
 */

@Mapper
public interface KyqkMapper {

    int updateKyqkHt(Kyqk kyqk);

    List<KyqkHt> selectKyqkListHt(Map<String, Object> map);

    List<KyqkHt> selectKyqk();

    List<Kyqk> selectKyqkList(Map<String, Object> map);

    List<Kyqk> selectKyqkLists(Map<String, Object> map);

    int insertKyqk(Kyqk kyqk);

    int updateByPrimaryKeySelective(Kyqk kyqk);
}
