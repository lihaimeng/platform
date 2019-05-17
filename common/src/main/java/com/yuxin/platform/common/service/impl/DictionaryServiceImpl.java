package com.yuxin.platform.common.service.impl;

import com.yuxin.platform.common.mapper.DictionaryMapper;
import com.yuxin.platform.common.model.Dictionary;
import com.yuxin.platform.common.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int insert(Dictionary record) {
        record.setCreateTime(new Date());
        record.setDicType("1");
        return dictionaryMapper.insertSelective(record);
    }

    @Override
    public Dictionary selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return dictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Dictionary selectByNameAndPdictId(Dictionary dictionary) {
        // TODO Auto-generated method stub
        return dictionaryMapper.selectByNameAndPdictId(dictionary);
    }

    @Override
    public Dictionary selectByDicCode(String dicCode) {
        // TODO Auto-generated method stub
        return dictionaryMapper.selectByDicCode(dicCode);
    }

    @Override
    public List<Dictionary> selectOptions(String dicCode) {
        // TODO Auto-generated method stub
        return dictionaryMapper.selectOptions(dicCode);
    }

    @Override
    public List<Dictionary> selectBussinessType(String dicCode) {
        return dictionaryMapper.selectMsgByDicCode(dicCode);
    }

    @Override
    public List<Dictionary> getDictionaryBypid(String pid) {
        return dictionaryMapper.selectByPid(pid);
    }

    @Override
    public int update(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(Integer id) {
        return dictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> getAbxx() {
        List<Dictionary> baxxs = dictionaryMapper.selectMsgByDicCode("0040");
        List<Dictionary> sflxs = dictionaryMapper.selectMsgByDicCode("0240");
        List<Dictionary> jfsbzls = dictionaryMapper.selectMsgByDicCode("005");
        Map<String, Object> map = new HashMap<>();
        map.put("baxxs", baxxs);
        map.put("sflxs", sflxs);
        map.put("jfsbzls", jfsbzls);
        return map;
    }

    @Override
    public List<Dictionary> selectDictionaryRecords() {
        return dictionaryMapper.selectDictionaryRecords();
    }
}
