/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
package com.yuxin.platform.upms.controller;

import com.yuxin.platform.upms.pojo.Param;
import com.yuxin.platform.upms.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/param")
public class ParamController {

    @Autowired
    private ParamService paramService;

    @RequestMapping(value = "/paramList", method = RequestMethod.GET)
    public List<Param> paramList() {
        List<Param> params = paramService.getAllParam();
        return params;
    }

    @RequestMapping(value = "/paramList2", method = RequestMethod.GET)
    public Map<String, Object> paramList2() {
        List<Param> params = paramService.getAllParam();
        Map<String, Object> map = new HashMap<>();
        map.put("result", params);
        return map;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Param param) {
        Map<String, Object> map = new HashMap<>();
        Param param1 = paramService.selectByCode(param.getCode());
        if (param1 != null) {
            map.put("result", "参数编码已存在");
        } else {
            int count = paramService.insert(param);
            if (count > 0) {
                map.put("result", "新增成功");
            } else {
                map.put("result", "新增失败");
            }
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Param param) {
        Map<String, Object> map = new HashMap<>();
        int count = paramService.update(param);
        if (count > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        int count = paramService.delete(id);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

}
