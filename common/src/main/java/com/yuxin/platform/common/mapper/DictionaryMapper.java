package com.yuxin.platform.common.mapper;

import com.yuxin.platform.common.model.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface DictionaryMapper {

    int insertSelective(Dictionary record);

    int updateByPrimaryKeySelective(Dictionary record);

    int deleteByPrimaryKey(Integer d);

    Dictionary selectByPrimaryKey(Integer id);

    Dictionary selectByNameAndPdictId(Dictionary dictionary);

    Dictionary selectByDicCode(String dicCode);

    /**
     * 查询行业类型
     *
     * @param dicCode
     * @return
     */
    List<Dictionary> selectMsgByDicCode(String dicCode);

    List<Dictionary> selectOptions(String dicCode);

    List<Dictionary> selectByPid(String pid);

    /**
     * 获取所有字典信息
     *
     * @return
     */
    List<Dictionary> selectDictionaryRecords();

}