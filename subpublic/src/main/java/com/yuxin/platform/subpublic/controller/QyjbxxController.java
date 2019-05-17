package com.yuxin.platform.subpublic.controller;

import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.service.AttachmentService;
import com.yuxin.platform.subpublic.dto.AttachmentDto;
import com.yuxin.platform.subpublic.dto.FileDto;
import com.yuxin.platform.subpublic.pojo.Qyjbxx;
import com.yuxin.platform.subpublic.pojo.QyjbxxExample;
import com.yuxin.platform.subpublic.pojo.QyjbxxZZ;
import com.yuxin.platform.subpublic.service.CyryService;
import com.yuxin.platform.subpublic.service.QyjbxxService;
import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 企业基本信息控制器
 *
 * @author wj
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/qyjbxx")
//@SessionAttributes("user")
public class QyjbxxController {

    @Autowired
    private QyjbxxService qyjbxxService;

    @Autowired
    private CyryService cyryService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private OrganizationService organizationService;


    @RequestMapping(value = "/selectQyjbxx", method = RequestMethod.GET)
    public List<Qyjbxx> selectQyjbxx(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByQyzt(user.getQyrybm());
        return qyjbxxes;
    }

    /**
     * 通过企业状态（默认0）查询
     *
     * @return 返回状态为0的企业信息
     */
    @RequestMapping(value = "/selectQyjbxxByqyzt", method = RequestMethod.GET)
    public List<Qyjbxx> selectQyjbxxByqyzt(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByQyxxzt(user);
        return qyjbxxes;
    }

    @RequestMapping(value = "/selectQyjbxxByqyzt_zh", method = RequestMethod.GET)
    public List<Qyjbxx> selectQyjbxxByqyztZhong(String organizationId) {
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByQyxxztZhong(organizationId);
        return qyjbxxes;
    }


    /**
     * 综治下企业管理通过企业状态（默认0）查询
     *
     * @return 返回状态为0的企业信息
     */
    @RequestMapping(value = "/selectQyjbxxByqyzt4zz", method = RequestMethod.GET)
    public List<Qyjbxx> selectQyjbxxByqyzt4zz() {
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByQyxxzt4zz();
        return qyjbxxes;
    }

    /**
     * 条件查询
     *
     * @param qyjbxx 包含条件信息
     * @return 返回符合条件的企业信息
     */
    @RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
    public List<Qyjbxx> selectByCondition(@RequestBody Qyjbxx qyjbxx, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByCondition(qyjbxx, user);
        return qyjbxxes;
    }

    /**
     * 综治条件查询
     *
     * @param  包含条件信息
     * @return 返回符合条件的企业信息
     */
    @RequestMapping(value = "/selectByConditionZong", method = RequestMethod.POST)
    public List<Qyjbxx> selectByConditionZong(@RequestBody QyjbxxZZ qyjbxxZZ) {
        User user = new User();
        user.setOrganizationId(Integer.parseInt(qyjbxxZZ.getOrganizationId()));
        Qyjbxx qyjbxx = new Qyjbxx();
        qyjbxx.setQymc(qyjbxxZZ.getQymc());
        qyjbxx.setFrdb(qyjbxxZZ.getFrdb());
        qyjbxx.setFrdbzjhm(qyjbxxZZ.getFrdbzjhm());
        qyjbxx.setGxdwbm(qyjbxxZZ.getGxdwbm());
        qyjbxx.setHylbdm(qyjbxxZZ.getHylbdm());
        qyjbxx.setQybm(qyjbxxZZ.getQybm());
        qyjbxx.setYyzzbh(qyjbxxZZ.getYyzzbh());
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByCondition(qyjbxx, user);
        return qyjbxxes;
    }

    /**
     * 条件查询
     *
     * @param qyjbxx 包含条件信息
     * @return 返回符合条件的企业信息
     */
    @RequestMapping(value = "/selectByCondition4zz", method = RequestMethod.POST)
    public List<Qyjbxx> selectByCondition4zz(@RequestBody Qyjbxx qyjbxx) {
        List<Qyjbxx> qyjbxxes = qyjbxxService.selectByCondition4zz(qyjbxx);
        return qyjbxxes;
    }

    /**
     * 新增企业信息
     *
     * @param qyjbxx 包含企业信息字段
     * @return 0-成功；1-添加企业管理员失败；2-添加企业信息失败；3-企业信息已存在
     */
    @RequestMapping(value = "/insertQyjbxx", method = RequestMethod.POST)
    public Map<String, Object> insertQyjbxx(@RequestBody Qyjbxx qyjbxx, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = qyjbxxService.insertSelective(qyjbxx, user);
        return map;
    }

    /**
     * 更新企业信息
     *
     * @param qyjbxx 包含企业信息更新字段
     * @return 1-更新成功；0-更新失败
     */
    @RequestMapping(value = "/updateQyjbxx", method = RequestMethod.POST)
    public int updateQyjbxx(@RequestBody Qyjbxx qyjbxx) {
        int i = qyjbxxService.updateByPrimaryKeySelective(qyjbxx);
        return i;
    }

    /**
     * 根据企业人员编码查询企业信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/selectByQYBM", method = RequestMethod.POST)
    public Qyjbxx selectByQYBM(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Qyjbxx qyjbxxes = qyjbxxService.selectByQybm(user.getQyrybm());
        return qyjbxxes;
    }

    /**
     * 根据管辖单位编码查询企业id
     *
     * @param gxdwbm
     * @return
     */
    @RequestMapping(value = "/selectByGxdwbm", method = RequestMethod.POST)
    public List<Integer> selectByGxdwbm(@RequestParam("gxdwbm") String gxdwbm) {
        QyjbxxExample qyjbxxExample = new QyjbxxExample();
        QyjbxxExample.Criteria criteria = qyjbxxExample.createCriteria();
        criteria.andGxdwbmEqualTo(gxdwbm);
        List<Qyjbxx> qyjbxxList = qyjbxxService.selectByExample(qyjbxxExample);
        List qyidList = new ArrayList();
        for (Qyjbxx qyjbxx : qyjbxxList) {
            qyidList.add(qyjbxx.getQyid());
        }
        return qyidList;
    }

    /**
     * 根据管辖单位编码模糊查询下辖企业id
     *
     * @param gxdwbm
     * @return
     */
    @RequestMapping(value = "/selectLikeGxdwbm", method = RequestMethod.POST)
    public List<Integer> selectLikeGxdwbm(@RequestParam("gxdwbm") String gxdwbm) {
        QyjbxxExample qyjbxxExample = new QyjbxxExample();
        QyjbxxExample.Criteria criteria = qyjbxxExample.createCriteria();
        criteria.andGxdwbmLike(gxdwbm + "%");
        List<Qyjbxx> qyjbxxList = qyjbxxService.selectByExample(qyjbxxExample);
        List qyidList = new ArrayList();
        for (Qyjbxx qyjbxx : qyjbxxList) {
            qyidList.add(qyjbxx.getQyid());
        }
        return qyidList;
    }

    /**
     * 根据管辖单位编码数组模糊查询下辖企业id
     *
     * @return
     */
    @RequestMapping(value = "/selectLikeGxdwbmarr", method = RequestMethod.POST)
    public Map selectLikeGxdwbmarr(@RequestParam("gxdwbmarr") List<String> gxdwbmarr) {
        Map map = new HashMap();
        for (String gxdwbm : gxdwbmarr) {
            QyjbxxExample qyjbxxExample = new QyjbxxExample();
            QyjbxxExample.Criteria criteria = qyjbxxExample.createCriteria();
            criteria.andGxdwbmLike(gxdwbm + "%");
            List<Qyjbxx> qyjbxxList = qyjbxxService.selectByExample(qyjbxxExample);
            List qyidList = new ArrayList();
            for (Qyjbxx qyjbxx : qyjbxxList) {
                qyidList.add(qyjbxx.getQyid());
            }
            map.put(gxdwbm, qyidList);
        }
        return map;
    }

    /**
     * 根据管辖单位编码查询典当企业数量
     *
     * @param gxdwbm
     * @return
     */
    @RequestMapping(value = "/selectDdqyfb", method = RequestMethod.POST)
    public Integer selectDdqyfb(@RequestParam("gxdwbm") String gxdwbm) {
        QyjbxxExample qyjbxxExample = new QyjbxxExample();
        QyjbxxExample.Criteria criteria = qyjbxxExample.createCriteria();
        criteria.andGxdwbmLike(gxdwbm + "%");
        criteria.andHylbdmEqualTo("01803");
        List<Qyjbxx> qyjbxxList = qyjbxxService.selectByExample(qyjbxxExample);
        int qynum = qyjbxxList.size();
        return qynum;
    }

    @RequestMapping(value = "/selectByid", method = RequestMethod.POST)
    public Qyjbxx selectByid(@RequestParam("qyid") Integer qyid) {
        Qyjbxx qyjbxx = new Qyjbxx();
        qyjbxx = qyjbxxService.selectByPrimaryKey(qyid);
        return qyjbxx;
    }

    /**
     * 根据企业id数组查询企业名称
     *
     * @return
     */
    @RequestMapping(value = "/selectByidarr", method = RequestMethod.POST)
    public Map selectByidarr(@RequestParam("qyidarr") List<Integer> qyidarr) {

        Set<Integer> qyidset = new HashSet();
        for (int qyid : qyidarr) {
            qyidset.add(qyid);
        }
        Map map = new HashMap();
        for (int qyid : qyidset) {
            Qyjbxx qyjbxx = new Qyjbxx();
            qyjbxx = qyjbxxService.selectByPrimaryKey(qyid);
            List list = new ArrayList();
            list.add(qyjbxx.getQymc());
            list.add(qyjbxx.getGxdwmc());
            map.put(qyid, list);
        }
        return map;
    }


    /**
     * 新增文件到数据库
     *
     * @param attachmentDto
     * @param user
     * @return
     */
    @RequestMapping(value = "/insertAttachment", method = RequestMethod.POST)
    public Map<String, Object> insertAttachment(@RequestBody AttachmentDto attachmentDto, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        if (attachmentDto != null) {
            List<FileDto> fileDtoList = attachmentDto.getFileDtoList();
            if (fileDtoList != null && fileDtoList.size() > 0) {
                for (int i = 0; i < fileDtoList.size(); i++) {
                    Attachments attachments = new Attachments();
                    attachments.setTableId(attachmentDto.getQyid());
                    attachments.setTableName(attachmentDto.getMkmc());
                    if (fileDtoList.get(i) != null) {
                        attachments.setFileName(fileDtoList.get(i).getFileName());
                        attachments.setMark(fileDtoList.get(i).getMark());
                        attachments.setRealPath(fileDtoList.get(i).getRealPath());
                        attachments.setFileType(fileDtoList.get(i).getFileType());
                        int insertAttach = cyryService.insertAttach(attachments, user.getUsername());
                        if (insertAttach == 1) {
                            map.put("success", "成功");
                        } else {
                            map.put("false", "失败");
                        }
                    }
                }
            }
        } else {
            map.put("false", "失败");
        }
        return map;
    }

    /**
     * 修改文件到数据库
     *
     * @param attachmentDto
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateAttachment", method = RequestMethod.POST)
    public Map<String, Object> updateAttachment(@RequestBody AttachmentDto attachmentDto, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Attachments attachments = new Attachments();
        Map<String, Object> map = new HashMap<String, Object>();
        if (attachmentDto != null) {
            attachments.setTableId(attachmentDto.getQyid());
            attachments.setTableName(attachmentDto.getMkmc());
            List<FileDto> fileDtoList = attachmentDto.getFileDtoList();
            for (int i = 0; i < fileDtoList.size(); i = i + 3) {
                if (fileDtoList.get(i) != null) {
                    attachments.setFileName(fileDtoList.get(i).getFileName());
                    attachments.setMark(fileDtoList.get(i).getMark());
                    attachments.setRealPath(fileDtoList.get(i).getRealPath());
                    attachments.setFileType(fileDtoList.get(i).getFileType());
                    int insertAttach = cyryService.updateAttach(attachments, user.getUsername());
                    if (insertAttach == 1) {
                        map.put("success", "成功");
                    } else {
                        map.put("false", "失败");
                    }
                }
            }
        } else {
            map.put("false", "失败");
        }
        return map;
    }

    /**
     * 获取企业相关文件信息
     *
     * @param attachments
     * @return
     */
    @RequestMapping(value = "/getFileMsg", method = RequestMethod.POST)
    public List<Attachments> getFileMsg(@RequestBody Attachments attachments) {
        List<Attachments> attachmentsList = attachmentService.selectAttachments(attachments);
        return attachmentsList;
    }

    @RequestMapping(value = "/getDominion")
    public List<Organization> getDominion(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Organization organization = organizationService.selectByPrimaryKey(user.getOrganizationId());
        List<Organization> organizations = organizationService.selectByBrevitycode(organization.getBrevitycode());
        return organizations;
    }

    @RequestMapping(value = "/getDominions")
    public List<Organization> getDominions(@RequestParam Map<String, Object> maps) {
        Organization organization = organizationService.selectByPrimaryKey(Integer.parseInt((String) maps.get("organizationId")));
        List<Organization> organizations = organizationService.selectByBrevitycode(organization.getBrevitycode());
        return organizations;
    }

    //用于可疑情况上报
    @RequestMapping(value = "/selectByQYRYBM", method = RequestMethod.POST)
    public Qyjbxx selectByQYRYBM(String qyrybm) {
        Qyjbxx qyjbxxes = qyjbxxService.selectByQybm(qyrybm);
        return qyjbxxes;
    }

    @RequestMapping(value = "/deleteFileMsg", method = RequestMethod.POST)
    public Map<String, Object> deleteFileMsg(@RequestBody Attachments attachments) {
        Map<String, Object> map = new HashMap<String, Object>();
        int count = qyjbxxService.deleteFileMsg(attachments);
        if (count >= 0) {
            map.put("result", "删除成功");
        } else {
            map.put("result", "删除失败");
        }
        return map;
    }


    /**
     * 同步新增印章系统企业信息
     * @param qyjbxx 包含企业信息字段
     * @return 0-成功；1-添加企业管理员失败；2-添加企业信息失败；3-企业信息已存在
     */
    @RequestMapping(value = "/insertQyjbxxBySeal", method = RequestMethod.POST)
    public Map<String, Object> insertQyjbxxBySeal(@RequestBody Qyjbxx qyjbxx, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = qyjbxxService.insertQyjbxxBySeal(qyjbxx, user);
        return map;
    }


}