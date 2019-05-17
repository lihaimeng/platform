package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.upms.mapper.OrganizationMapper;
import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.dto.SealDto;
import com.yuxin.platform.zongzhi.dto.SubSealInfoDto;
import com.yuxin.platform.zongzhi.mapper.SubSealInfoMapper;
import com.yuxin.platform.zongzhi.pojo.SubSealInfo;
import com.yuxin.platform.zongzhi.service.SubSealInfoService;
import com.yuxin.platform.zongzhi.vo.SealVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 印章相关信息service实现类
 *
 * @author wj
 */
@Service
public class SubSealInfoServiceImpl implements SubSealInfoService {

    @Autowired
    private SubSealInfoMapper subSealInfoMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    /**
     * 查询所有印章信息
     *
     * @return
     */
    @Override
    public List<SubSealInfo> selectSealInfo(User user) {
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        SubSealInfo subSealInfo = new SubSealInfo();
        subSealInfo.setDominionCode(organization.getBrevitycode());
        return subSealInfoMapper.selectSealInfo(subSealInfo);
    }

    /**
     * 条件查询印章信息
     *
     * @param subSealInfoDto
     * @return
     */
    @Override
    public List<SubSealInfo> selectSealInfoByParams(SubSealInfoDto subSealInfoDto, User user) {

        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        String brevitycode = organization.getBrevitycode();
        if (subSealInfoDto.getDominionCode() == null || subSealInfoDto.getDominionCode() == "") {
            subSealInfoDto.setDominionCode(brevitycode);
        } else {
            if (subSealInfoDto.getDominionCode().indexOf("00") != -1) {
                brevitycode = subSealInfoDto.getDominionCode().substring(0, 4);
                subSealInfoDto.setDominionCode(brevitycode);
            }
        }
        return subSealInfoMapper.selectSealInfoByParams(subSealInfoDto);
    }

    /**
     * 统计使用单位和制作单位数量
     *
     * @return
     */
    @Override
    public Map<String, Object> countCompany() {
        Map<String, Object> map = new HashMap<>();
        int countCompany = subSealInfoMapper.selectByCompanyName();
        int countMarkCompany = subSealInfoMapper.selectByMarkCompanyName();
        map.put("companyCount", countCompany);
        map.put("markCompanyCount", countMarkCompany);
        return map;
    }

    /**
     * 统计印章材质，印章形状，中心图案数量
     *
     * @return
     */
    @Override
    public Map<String, Object> countSeal() {
        Map<String, Object> map = new HashMap<>();
        int selectBySealMaterial = subSealInfoMapper.selectBySealMaterial();
        int selectBySealPattern = subSealInfoMapper.selectBySealPattern();
        int selectBySealShape = subSealInfoMapper.selectBySealShape();
        map.put("sealMaterial", selectBySealMaterial);
        map.put("sealPattern", selectBySealPattern);
        map.put("sealShape", selectBySealShape);
        return map;
    }

    /**
     * 按月统计单位数量
     *
     * @return
     */
    @Override
    public Map<String, Object> countSealCompanyByMonth() {
        Map<String, Object> map = new HashMap<>();
        List<Integer> countSealCompanyByMonth = subSealInfoMapper.countSealCompanyByMonth();
        List<Integer> countSealMarkCompanyByMonth = subSealInfoMapper.countSealMarkCompanyByMonth();
        List<String> dates = subSealInfoMapper.selectSealDate();
        map.put("countSealCompanyByMonth", countSealCompanyByMonth);
        map.put("countSealMarkCompanyByMonth", countSealMarkCompanyByMonth);
        map.put("companyDates", dates);
        return map;
    }

    @Override
    public Map<String, Object> countSealByMonth() {
        Map<String, Object> map = new HashMap<>();
        List<String> dates = subSealInfoMapper.selectSealDate();
        List<Integer> countSealByMonth = subSealInfoMapper.countSealByMonth();
        map.put("countSealNum", countSealByMonth);
        map.put("companyDates", dates);
        return map;
    }

    @Override
    public Map<String, Object> selectSealMsg(User user) {
        Map<String, Object> map = new HashMap<>();
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        String brevitycode = organization.getBrevitycode();
        SealDto sealDto = new SealDto();
        sealDto.setOrganizationId(user.getOrganizationId());
        sealDto.setDominionCode(brevitycode);
        List<SealVo> sealByDominion = subSealInfoMapper.selectSealByDominion(sealDto);
        map.put("sealNumByDominion", sealByDominion);
        List<SealVo> sealByType = subSealInfoMapper.selectSealByType(brevitycode);
        List<SealVo> companyNum = subSealInfoMapper.sealCompanyByWeek(brevitycode);
        map.put("companyNum", companyNum);
        map.put("sealNumByType", sealByType);
        return map;
    }

    @Override
    public Map<String, Object> getSealMsgByDominion(SealDto sealDto, User user) {
        Map<String, Object> map = new HashMap<>();
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        String brevitycode = organization.getBrevitycode();
        sealDto.setDominionCode(brevitycode);
        sealDto.setOrganizationId(user.getOrganizationId());
        String dateMark = sealDto.getDateMark();
        List<SealVo> list = new ArrayList<>();
        if ("week".equals(dateMark)) {
            list = subSealInfoMapper.countSealMsgByDominionWeek(sealDto);
        } else if ("month".equals(dateMark)) {
            list = subSealInfoMapper.countSealMsgByDominionMonth(sealDto);
        } else if ("year".equals(dateMark)) {
            list = subSealInfoMapper.countSealMsgByDominionYear(sealDto);
        }
        map.put("countSealMsgByDominion", list);
        return map;
    }

    @Override
    public Map<String, Object> getSealMsgBySealType(SealDto sealDto, User user) {
        Map<String, Object> map = new HashMap<>();
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        String brevitycode = organization.getBrevitycode();
        sealDto.setDominionCode(brevitycode);
        String dateMark = sealDto.getDateMark();
        List<SealVo> list = new ArrayList<>();
        if ("week".equals(dateMark)) {
            list = subSealInfoMapper.selectSealByDateWeek(sealDto);
        } else if ("month".equals(dateMark)) {
            list = subSealInfoMapper.selectSealByDateMonth(sealDto);
        } else if ("year".equals(dateMark)) {
            list = subSealInfoMapper.selectSealByDateYear(sealDto);
        }
        map.put("countSealMsgBySealType", list);
        return map;
    }

    @Override
    public Map<String, Object> getSealCompanyByTime(SealDto sealDto, User user) {
        Map<String, Object> map = new HashMap<>();
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        String brevitycode = organization.getBrevitycode();
        sealDto.setDominionCode(brevitycode);
        String dateMark = sealDto.getDateMark();
        List<SealVo> list = new ArrayList<>();
        if ("week".equals(dateMark)) {
            list = subSealInfoMapper.sealCompanyByDateWeek(sealDto);
        } else if ("month".equals(dateMark)) {
            list = subSealInfoMapper.sealCompanyByDateMonth(sealDto);
        } else if ("year".equals(dateMark)) {
            list = subSealInfoMapper.sealCompanyByDateYear(sealDto);
        }
        map.put("sealCompany", list);
        return map;
    }
}
