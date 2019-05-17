package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.service.OrganizationService;
import com.yuxin.platform.zongzhi.dto.SealDto;
import com.yuxin.platform.zongzhi.dto.SubSealInfoDto;
import com.yuxin.platform.zongzhi.pojo.SubSealInfo;
import com.yuxin.platform.zongzhi.service.SubSealInfoService;
import com.yuxin.platform.zongzhi.vo.SealVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 印章相关信息控制器
 *
 * @author wj
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/seal")
@RestController
@SessionAttributes("user")
public class SubSealInfoController {

    @Autowired
    private SubSealInfoService subSealInfoService;

    @Autowired
    private OrganizationService organizationService;

    /**
     * 查询印章相关信息
     *
     * @return
     */
    @RequestMapping(value = "/selectSealInfo")
    public List<SubSealInfo> selectSealInfo(@ModelAttribute("user") User user) {
        List<SubSealInfo> subSealInfos = subSealInfoService.selectSealInfo(user);
        return subSealInfos;
    }

    /**
     * 条件查询印章相关信息
     *
     * @param subSealInfoDto
     * @return
     */
    @RequestMapping(value = "/selectSealInfoByParams", method = RequestMethod.POST)
    public List<SubSealInfo> selectSealInfoByParams(@RequestBody SubSealInfoDto subSealInfoDto, @ModelAttribute("user") User user) {
        List<SubSealInfo> subSealInfos = subSealInfoService.selectSealInfoByParams(subSealInfoDto, user);
        return subSealInfos;
    }

    /**
     * 统计印章使用单位和制作单位数量
     *
     * @return
     */
    @RequestMapping(value = "/countCompany")
    public Map<String, Object> countCompany() {
        Map<String, Object> map = subSealInfoService.countCompany();
        return map;
    }

    /**
     * 统计印章材质，形状，中心图案数量
     *
     * @return
     */
    @RequestMapping(value = "/countSeal")
    public Map<String, Object> countSeal() {
        Map<String, Object> map = subSealInfoService.countSeal();
        return map;
    }

    /**
     * 按月统计印章使用单位和制作单位数量
     *
     * @return
     */
    @RequestMapping(value = "/countSealCompanyByMonth")
    public Map<String, Object> countSealCompanyByMonth() {
        Map<String, Object> map = subSealInfoService.countSealCompanyByMonth();
        return map;
    }

    /**
     * 按月统计印章数量
     *
     * @return
     */
    @RequestMapping(value = "/countSealByMonth")
    public Map<String, Object> countSealByMonth() {
        Map<String, Object> map = subSealInfoService.countSealByMonth();
        return map;
    }

    /**
     * 获取管辖区域
     *
     * @return
     */
    @RequestMapping(value = "/getDominion")
    public List<Organization> getDominion(@ModelAttribute("user") User user) {
        Organization organization = organizationService.selectByPrimaryKey(user.getOrganizationId());
        List<Organization> organizations = organizationService.selectByBrevitycode(organization.getBrevitycode());
        return organizations;
    }

    /**
     * 综治下获取管辖区域
     *
     * @return
     */
    @RequestMapping(value = "/getDominion4zz")
    public List<Organization> getDominion4zz(@ModelAttribute("user") User user) {
        Organization organization = organizationService.selectByPrimaryKey(user.getOrganizationId());
        List<Organization> organizations = organizationService.selectByBrevitycode4zz(organization.getBrevitycode());
        return organizations;
    }

    @ApiOperation(value = "印章统计接口", notes = "不需要传参数，直接请求。" +
            "返回数据：sealCompanyByWeek(通过区域统计使用单位数量):{companyAddDate:注册时间，sealUseNum:使用单位数量}；" +
            "sealNumByDominion(通过区域统计印章业务数量)：{dominionName:区域名，sealNum:印章业务数量}；" +
            "sealNumByType(通过印章类型统计印章业务数量)：{sealType:印章类型名称，sealTypeNum:该类型下印章业务数量}；；",
            response = Map.class, httpMethod = "GET")
    @RequestMapping(value = "/getSealMsg")
    public Map<String, Object> getSealMsg(@ModelAttribute("user") User user) {
        Map<String, Object> map = subSealInfoService.selectSealMsg(user);
        return map;
    }

    @ApiOperation(value = "印章条件统计接口", notes = "返回数据：sealNumByMarkAndWeek(通过类型统计一周印章数量):{sealTypeNum:印章类型数量，sealDate:印章时间，sealType：印章类型，sealNum:印章数量，dominionName：印章区域，sealMarkNum:制作单位数量,sealUseNum:使用单位数量}；" +
            "sealNumByMarkAndMonth(通过类型统计一个月印章数量):{sealTypeNum:印章类型数量，sealDate:印章时间，sealType：印章类型，sealNum:印章数量，dominionName：印章区域，sealMarkNum:制作单位数量,sealUseNum:使用单位数量}；" +
            "sealNumByMarkAndYear(通过类型统计一年印章数量):{sealTypeNum:印章类型数量，sealDate:印章时间，sealType：印章类型，sealNum:印章数量，dominionName：印章区域，sealMarkNum:制作单位数量,sealUseNum:使用单位数量}；" +
            "sealByDateWeek(统计一周印章数量):{sealTypeNum:印章类型数量，sealDate:印章时间，sealType：印章类型,sealNum:印章数量，sealDate:印章时间，dominionName：印章区域，sealMarkNum:制作单位数量,sealUseNum:使用单位数量}" +
            "sealByDateMonth(统计一周印章数量):{sealTypeNum:印章类型数量，sealDate:印章时间，sealType：印章类型,sealNum:印章数量，sealDate:印章时间，dominionName：印章区域，sealMarkNum:制作单位数量,sealUseNum:使用单位数量}" +
            "sealByDateYear(统计一周印章数量):{sealTypeNum:印章类型数量，sealDate:印章时间，sealType：印章类型,sealNum:印章数量，sealDate:印章时间，dominionName：印章区域,sealMarkNum:制作单位数量,sealUseNum:使用单位数量}" +
            "sealCompany(印章使用单位增量):{companyAddDate:使用单位注册时间，sealUseNum:使用单位数量}",
            response = SealVo.class, httpMethod = "POST")
    @RequestMapping(value = "/getSealMsgByCondition", method = RequestMethod.POST)
    public Map<String, Object> getSealMsgByCondition(@ApiParam("印章参数:mark(标记：company),dateMark(时间标记：week/month/year)," +
            "可选：registerDateStart(时间查询开始)，registerDateEnd(时间查询结束)") @RequestBody SealDto sealDto, @ModelAttribute("user") User user) {
        String mark = sealDto.getMark();
        Map<String, Object> map = new HashMap<>();
        if ("dominion".equals(mark)) {
            Map<String, Object> sealMsgByDominion = subSealInfoService.getSealMsgByDominion(sealDto, user);
            map.put("countSealMsgByDominion", sealMsgByDominion.get("countSealMsgByDominion"));
        } else if ("company".equals(mark)) {
            Map<String, Object> sealCompanyByTime = subSealInfoService.getSealCompanyByTime(sealDto, user);
            map.put("sealCompany", sealCompanyByTime.get("sealCompany"));
        } else if ("sealType".equals(mark)) {
            Map<String, Object> sealMsgBySealType = subSealInfoService.getSealMsgBySealType(sealDto, user);
            map.put("countSealMsgBySealType", sealMsgBySealType.get("countSealMsgBySealType"));
        }
        return map;
    }

}
