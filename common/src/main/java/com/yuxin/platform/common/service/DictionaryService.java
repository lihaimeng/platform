/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
package com.yuxin.platform.common.service;

import com.yuxin.platform.common.model.Dictionary;

import java.util.List;
import java.util.Map;


public interface DictionaryService {

    int insert(Dictionary record);

    int update(Dictionary record);

    int delete(Integer id);

    Dictionary selectByPrimaryKey(Integer id);

    Dictionary selectByNameAndPdictId(Dictionary dictionary);

    Dictionary selectByDicCode(String dicCode);

    /**
     * 查询行业类型
     *
     * @param dicCode
     * @return
     */
    List<Dictionary> selectBussinessType(String dicCode);

    List<Dictionary> getDictionaryBypid(String pid);

    /**
     * 获取安保信息
     *
     * @return
     */
    Map<String, Object> getAbxx();

    List<Dictionary> selectOptions(String code);

    List<Dictionary> selectDictionaryRecords();
}
