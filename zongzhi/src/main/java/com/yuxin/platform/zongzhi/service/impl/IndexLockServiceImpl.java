package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.common.model.SubLockOrder;
import com.yuxin.platform.upms.mapper.OrganizationMapper;
import com.yuxin.platform.upms.mapper.RoleMapper;
import com.yuxin.platform.upms.mapper.UserRoleMapper;
import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.service.IndexLockService;
import com.yuxin.platform.zongzhiserver.lock.mapper.SubLockOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class IndexLockServiceImpl implements IndexLockService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private SubLockOrderMapper subLockOrderMapper;

    /*
     * @author zzd
     * 获得当前登录用户地区业务数据情况
     * flag day:从今日0点到当前时间     month：本月1日到当前
     * @return Map
     */
    @Override
    public List<Map<String, Object>> getCountsOfOrganization(User user, Map<String, Object> param) {
        List<Map<String, Object>> qysjList = new ArrayList<Map<String, Object>>();
        if (param.get("flag") != null && "day".equals(param.get("flag"))) {
            param.putAll(initDateByDay());
        }
        if (param.get("flag") != null && "month".equals(param.get("flag"))) {
            param.putAll(initDateByMonth());
        }
        //获取当前用户管辖区域的下一级区域 如用户为省管理员，则获取所有所辖市区
        if (user.getOrganizationId() != null && !"".equals(user.getOrganizationId())) {

            findorganization(user, param);

            qysjList = subLockOrderMapper.selectByGxdwbm(param);
        }
        return qysjList;
    }

    private void findorganization(User user, Map<String, Object> param) {
        List<Organization> Organization = organizationMapper.selectByPid(user.getOrganizationId());
        if(Organization.size()==0){
            param.put("pid",null );
            param.put("organizationid", user.getOrganizationId());
        }else{
            param.put("pid",user.getOrganizationId() );
            param.put("organizationid", null);
        }
    }

    /*
     * @author zzd
     * 获取各开锁类型占比情况
     * 实现：1获得当前登录用户所在机构(机构表)，
     *       2根据机构简码（机构简码=管辖单位编码），分组查询查询开锁类型
     * @return Map
     */
    @Override
    public List<Map<String, Object>> getCountsOfKslx(User user, Map<String, Object> param) {
        List<Map<String, Object>> kslxList = new ArrayList<Map<String, Object>>();
        if (param.get("flag") != null && "day".equals(param.get("flag"))) {
            param.putAll(initDateByDay());
        }
        if (param.get("flag") != null && "month".equals(param.get("flag"))) {
            param.putAll(initDateByMonth());
        }
        if (user.getOrganizationId() != null && !"".equals(user.getOrganizationId())) {
            Organization Organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
            if (Organization != null) {
                String gxdwjm = Organization.getBrevitycode();
                param.put("gxdw", gxdwjm);
                kslxList = subLockOrderMapper.selectGroupByGxdwbm(param);
            }
        }
        return kslxList;
    }

    /**
     * 开锁企业分布情况
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getCountsOfQyfb(User user, Map<String, Object> param) {
        Map<String, Object> lockMap = new HashMap<String, Object>();
        List<Map<String, Object>> qyfbList = new ArrayList<Map<String, Object>>();
        if (param.get("flag") != null && "day".equals(param.get("flag"))) {
            param.putAll(initDateByDay());
        }
        if (param.get("flag") != null && "month".equals(param.get("flag"))) {
            param.putAll(initDateByMonth());
        }
        if (user.getOrganizationId() != null && !"".equals(user.getOrganizationId())) {
            findorganization(user, param);
            qyfbList = subLockOrderMapper.selectByGxdwbm1(param);
        }
        return qyfbList;
    }


    /*
     * @author zzd
     * 获得委托人数量增长情况
     * 实现：1获得当前登录用户所在机构(机构表)，
     *       2根据机构简码（机构简码=管辖单位编码），按 月/天 分组，查询每月/天去重后的委托人身份证数
     * @return Map
     */
    @Override
    public List<Map<String, Object>> getCountsOfWtr(User user, Map<String, Object> param) {
        List<Map<String, Object>> wtrList = new ArrayList<Map<String, Object>>();
        //获取当前用户管辖区域
        if (user.getOrganizationId() != null && !"".equals(user.getOrganizationId())) {
            //获取当前用户管辖区域
            Organization Organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
            if (Organization != null) {
                String gxdwjm = Organization.getBrevitycode();
                param.put("gxdw", gxdwjm);
                //最近7天数据
                if (param.get("flag") != null && "day".equals(param.get("flag"))) {
                    wtrList = subLockOrderMapper.selectLastSevenDay(param);
                }
                //某年份数据（年份在param里面，键：year）
                if (param.get("flag") == null || "year".equals(param.get("flag"))) {
                    wtrList = subLockOrderMapper.selectOfyear(param);
                }
            }
        }
        return wtrList;
    }


    /**
     * 获取时间区间：最近7天
     *
     * @return
     */
    public Map<String, Object> initDateByDay() {
        Map<String, Object> dataParam = new HashMap<String, Object>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endStr = format.format(new Date());
        String beginStr = format.format(today);
        dataParam.put("beginStr", beginStr);
        dataParam.put("endStr", endStr);
        return dataParam;
    }

    /**
     * 获得最近30天
     *
     * @return
     */
    public Map<String, Object> initDateByMonth() {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Map<String, Object> dataParam = new HashMap<String, Object>();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        String beginStr = d.format(calendar.getTime());
        String endStr = d.format(new Date());//当日时间0点钟
        dataParam.put("beginStr", beginStr);
        dataParam.put("endStr", endStr);
        return dataParam;
    }

    /**
     * 时间转换成字符串
     *
     * @return
     */
    public String timeToStr(Date date) {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        String str = d.format(date);//当日时间0点钟
        return str;
    }
}
