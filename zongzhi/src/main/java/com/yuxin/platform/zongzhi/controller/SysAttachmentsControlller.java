package com.yuxin.platform.zongzhi.controller;


import com.yuxin.platform.zongzhi.pojo.SysAttachments;
import com.yuxin.platform.zongzhi.pojo.SysAttachmentsExample;
import com.yuxin.platform.zongzhi.service.DmXctbService;
import com.yuxin.platform.zongzhi.service.SysAttachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sysAttachments")
public class SysAttachmentsControlller {
    @Autowired
    private SysAttachmentsService SysAttachmentsService;

    @Autowired
    private DmXctbService dmXctbService;

    @RequestMapping(value = "/selectByPrimaryKey/{tbid}", method = RequestMethod.GET)
    public SysAttachments selectByPrimaryKey(@PathVariable Integer id) {
        SysAttachments SysAttachments = SysAttachmentsService.selectByPrimaryKey(id);
        return SysAttachments;
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody SysAttachments record) {
        System.out.println("record:" + record);
        return SysAttachmentsService.insertSelective(record);
    }

    @RequestMapping(value = "/insertSelectiveState", method = RequestMethod.GET)
    public int insertSelectiveState(int state, String filename) {
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int insertstate = 0;
        System.out.println("state:" + state + ",filename:" + filename);
        if (state == 0) { //状态0新增页面的文件上传，新增连接
            SysAttachments SysAttachments = new SysAttachments();
            SysAttachments.setFileName(filename);
            SysAttachments.setTableName("dm_xctb");
            SysAttachments.setTableId(dmXctbService.selectLastid(1).getTbid());
            SysAttachments.setCreateDate(new Date());
            SysAttachments.setRealPath(courseFile + File.separator + "uploaded" + File.separator + filename);
            insertstate = SysAttachmentsService.insertSelective(SysAttachments);
        } else {  //修改页面的上传，新增的TableId为前台修改页面传来的tableid
            SysAttachments SysAttachments = new SysAttachments();
            SysAttachments.setFileName(filename);
            SysAttachments.setTableName("dm_xctb");
            SysAttachments.setTableId(state);
            SysAttachments.setCreateDate(new Date());
            SysAttachments.setRealPath(courseFile + File.separator + "uploaded" + File.separator + filename);
            insertstate = SysAttachmentsService.insertSelective(SysAttachments);
        }
        return insertstate;
    }


    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    public List<SysAttachments> selectByExample(@RequestBody SysAttachments record) {
        System.out.println("sysAttachments record:" + record);
        SysAttachmentsExample sysAttachmentsExample = new SysAttachmentsExample();
        SysAttachmentsExample.Criteria criteria = sysAttachmentsExample.createCriteria();

        criteria.andTableNameEqualTo(record.getTableName());
        criteria.andTableIdEqualTo(record.getTableId());
        List<SysAttachments> sysAttachments = SysAttachmentsService.selectByExample(sysAttachmentsExample);

        System.out.println("返回sysAttachments:" + sysAttachments);

        if (sysAttachments.size() > 0) {
            File file = new File(sysAttachments.get(0).getRealPath());
            if (file.exists()) {
                return sysAttachments;
            } else {
                sysAttachments.add(new SysAttachments());
                return sysAttachments;
            }
        } else {
            return sysAttachments;
        }

    }

    @RequestMapping(value = "/deleteByPrimaryKey/{tbid}", method = RequestMethod.GET)
    public int deleteByPrimaryKey(@PathVariable Integer tbid) {
        SysAttachments sysAttachments = SysAttachmentsService.selectByPrimaryKey(tbid);
        String realPath = sysAttachments.getRealPath();
        System.out.println("realPath:" + realPath);
        File file = new File(realPath);
        if (file.exists()) {
            System.out.println("删除文件");
            file.delete();
        }

        return SysAttachmentsService.deleteByPrimaryKey(tbid);
    }


}
