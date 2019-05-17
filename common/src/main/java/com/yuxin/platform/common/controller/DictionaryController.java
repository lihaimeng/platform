package com.yuxin.platform.common.controller;

import com.yuxin.platform.common.model.Dictionary;
import com.yuxin.platform.common.service.DictionaryService;
import com.yuxin.platform.upms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@RestController
@RequestMapping(value = "/dictionary")
@SessionAttributes("user")
public class DictionaryController {


    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Dictionary dictionary) {
        Map<String, Object> map = new HashMap<>();
        Dictionary pdictionary = dictionaryService.selectByPrimaryKey(Integer.parseInt(dictionary.getPdictId()));
        Dictionary dictionary1 = dictionaryService.selectByNameAndPdictId(dictionary);
        Dictionary dictionary2 = dictionaryService.selectByDicCode(dictionary.getDicCode());
        if (!dictionary.getDicCode().startsWith(pdictionary.getDicCode())) {
            map.put("result", "字典编号请以" + pdictionary.getDicCode() + "开始");
        } else if (dictionary1 != null) {
            map.put("result", "字典名称已存在");
        } else if (dictionary2 != null) {
            map.put("result", "字典编号已存在");
        } else {
            int count = dictionaryService.insert(dictionary);
            if (count > 0) {
                map.put("result", "新增成功");
            } else {
                map.put("result", "新增失败");
            }
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Dictionary dictionary) {
        Map<String, Object> map = new HashMap<>();
        int count = dictionaryService.update(dictionary);
        if (count > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    @SuppressWarnings("null")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public List<Dictionary> organizationBypid(@PathVariable String pid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Dictionary> dictionary = dictionaryService.getDictionaryBypid(pid);
        return dictionary;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        int count = dictionaryService.delete(id);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }


    /**
     * 获取安保信息下拉列表数据
     *
     * @return
     */
    @RequestMapping(value = "/getAbxx")
    public Map<String, Object> getAbxx() {
        return dictionaryService.getAbxx();
    }

    /*
    根据编码获取下拉列表
     */
    @RequestMapping(value = "/selectOptions", method = RequestMethod.GET)
    public Map<String, Object> selectOptions(@RequestParam Map<String, Object> map, @ModelAttribute("user") User user) {
        Map<String, Object> maps = new HashMap<String, Object>();
        String code = (String) map.get("code");
        String[] codes = code.split(",");
        if (codes.length > 0) {
            for (int i = 0; i < codes.length; i++) {
                List<Dictionary> list = dictionaryService.selectOptions(codes[i]);
                maps.put("result" + codes[i], list);
            }
        }
        return maps;
    }

    @RequestMapping(value = "/getAllRecords")
    public List<Dictionary> getDictionaryRecords() {
        List<Dictionary> dictionarie = new ArrayList<>();
        dictionarie = dictionaryService.selectDictionaryRecords();
        return dictionarie;
    }

    @RequestMapping(value = "/getKyqkType",method = RequestMethod.POST)
    public List<Dictionary> getKyqkType() {
        List<Dictionary> dictionaries = dictionaryService.selectBussinessType("0190");
        return dictionaries;
    }
    @RequestMapping(value = "/getBussinessType",method = RequestMethod.POST)
    public List<Dictionary> getBussinessType() {
        List<Dictionary> dictionaries = dictionaryService.selectBussinessType("0180");
        return dictionaries;
    }
}
