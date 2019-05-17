package com.yuxin.platform.subpublic.service.impl;

import com.yuxin.platform.common.mapper.AttachmentsMapper;
import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.util.GenerateCode;
import com.yuxin.platform.subpublic.mapper.QyjbxxMapper;
import com.yuxin.platform.subpublic.mapper.QyryxxMapper;
import com.yuxin.platform.subpublic.pojo.Qyjbxx;
import com.yuxin.platform.subpublic.pojo.QyjbxxExample;
import com.yuxin.platform.subpublic.pojo.Qyryxx;
import com.yuxin.platform.subpublic.service.QyjbxxService;
import com.yuxin.platform.upms.mapper.OrganizationMapper;
import com.yuxin.platform.upms.mapper.UserMapper;
import com.yuxin.platform.upms.mapper.UserRoleMapper;
import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.pojo.UserRole;
import com.yuxin.platform.upms.util.CipherUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 企业基本信息service实现类
 */
@Service
public class QyjbxxServiceImpl implements QyjbxxService {


    @Autowired
    private QyjbxxMapper qyjbxxMapper;

    @Autowired
    private QyryxxMapper qyryxxMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private AttachmentsMapper attachmentsMapper;

    @Value("${roleId}")
    private int roleId;

    @Value("${password}")
    private String password;

    @Value("${status}")
    private String status;

    @Value("${hyType}")
    private String hyType;

    @Value("${qybj}")
    private String qybj;

    /**
     * 新增企业信息
     *
     * @param record
     * @return
     */
    @Transactional
    @Override
    public Map<String, Object> insertSelective(Qyjbxx record, User loginUser) {
        Map<String, Object> map = new HashMap<>();
        Qyjbxx qyjbxxy = qyjbxxMapper.selectByQymc(record.getQymc());
        if (qyjbxxy == null) {
            Organization organization1 = organizationMapper.selectByPrimaryKey(loginUser.getOrganizationId());
            record.setHylbdm(hyType);
            record.setLrsj(new Date());
            String qybm = GenerateCode.strFormat(//生成cyrybm
                    qybj, hyType, record.getGxdwbm(), getDeailyMaxQybm(record));
            record.setQybm(qybm);
            int i = qyjbxxMapper.insertSelective(record);
            if (i > 0) {
                Qyjbxx qyjbxx = qyjbxxMapper.selectByQymc(record.getQymc());
                Organization organization = organizationMapper.selectByCode(record.getGxdwbm());
                User user = new User();
                user.setUsername(qyjbxx.getQybm());
                user.setPassword(CipherUtil.generatePassword(password));
                user.setOrganizationId(organization.getOrganizationId());
                user.setQyrybm(qyjbxx.getQybm());
                user.setPhone(qyjbxx.getLxdh());
                user.setStatus(Byte.parseByte(status));
                user.setRealname(qyjbxx.getQymc());
                user.setAddtime(new Date());
                int i1 = userMapper.insertSelective(user);
                if (i1 > 0) {
                    UserRole userRole = new UserRole();
                    userRole.setRoleId(roleId);
                    User userName = userMapper.selectByUserName(qyjbxx.getQybm().toString());
                    userRole.setUserId(userName.getUserId());
                    int i2 = userRoleMapper.insertSelective(userRole);
                    if (i2 > 0) {
                        map.put("result", 0);
                        map.put("qyid", qyjbxx.getQyid());
                        //成功
                        return map;
                    } else {
                        map.put("result", 1);
                        //添加企业管理员失败
                        return map;
                    }
                } else {
                    map.put("result", 1);
                    //添加企业管理员失败
                    return map;
                }
            } else {
                map.put("result", 2);
                //添加企业信息失败
                return map;
            }
        } else {
            map.put("result", 3);
            //企业信息已存在
            return map;
        }
    }

    /**
     * 通过企业信息id查询
     *
     * @param qyid
     * @return
     */
    @Override
    public Qyjbxx selectByPrimaryKey(Integer qyid) {
        return qyjbxxMapper.selectByPrimaryKey(qyid);
    }

    /**
     * @param qymc
     * @return
     */
    @Override
    public List<Qyjbxx> selectByQyzt(String qymc) {
        return null;
    }

    /**
     * 查询所有企业信息
     *
     * @return
     */
    @Override
    public List<Qyjbxx> selectByQyxxzt(User user) {
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        Qyjbxx qyjbxx = new Qyjbxx();
        qyjbxx.setGxdwbm(organization.getBrevitycode());
        return qyjbxxMapper.selectByQyzt(qyjbxx);
    }

    /**
     * 查询所有企业信息
     *
     * @return
     */
    @Override
    public List<Qyjbxx> selectByQyxxztZhong(String id) {
        Organization organization = organizationMapper.selectByPrimaryKey(Integer.parseInt(id));
        Qyjbxx qyjbxx = new Qyjbxx();
        qyjbxx.setGxdwbm(organization.getBrevitycode());
        return qyjbxxMapper.selectByQyzt(qyjbxx);
    }

    @Override
    public List<Qyjbxx> selectByQyxxzt4zz() {
        return qyjbxxMapper.selectByQyzt4zz();
    }

    /**
     * 根据企业编码查询企业信息
     *
     * @return
     */
    @Override
    public Qyjbxx selectByQybm(String qybm) {
        return qyjbxxMapper.selectByQybm(qybm);
    }

    /**
     * 通过条件查询企业信息
     *
     * @param qyjbxx
     * @return
     */
    @Override
    public List<Qyjbxx> selectByCondition(Qyjbxx qyjbxx, User user) {
        Organization organization = organizationMapper.selectByPrimaryKey(user.getOrganizationId());
        if (qyjbxx.getGxdwbm() == null || "".equals(qyjbxx.getGxdwbm())) {
            qyjbxx.setGxdwbm(organization.getBrevitycode());
        }
        return qyjbxxMapper.selectByCondition(qyjbxx);
    }

    @Override
    public List<Qyjbxx> selectByCondition4zz(Qyjbxx qyjbxx) {
        if (qyjbxx.getGxdwbm().indexOf("00") != -1) {
            qyjbxx.setGxdwbm(qyjbxx.getGxdwbm().substring(0, 4));
        }
        return qyjbxxMapper.selectByCondition(qyjbxx);
    }

    /**
     * 更新企业信息
     *
     * @param record
     * @return
     */
    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Qyjbxx record) {
        if (record.getZt() == "1") {
            List<Qyryxx> qyryxxes = qyryxxMapper.selectByQyid(record.getQyid());
            if (qyryxxes == null && qyryxxes.size() == 0) {
                return qyjbxxMapper.updateByPrimaryKeySelective(record);
            } else {
                return -1;
            }
        }
        return qyjbxxMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 更新企业信息
     *
     * @param record
     * @return
     */
    @Transactional
    @Override
    public int updateByPrimaryKey(Qyjbxx record) {
        return qyjbxxMapper.updateByPrimaryKey(record);
    }

    @Transactional
    @Override
    public List<Qyjbxx> selectByExample(QyjbxxExample example) {
        return qyjbxxMapper.selectByExample(example);
    }

    @Override
    public int deleteFileMsg(Attachments attachments) {
        File file = new File(attachments.getRealPath());
        int num = 0;
        if (file != null) {
            if (file.delete()) {
                System.out.println(file.getName() + "is deleted");
            } else {
                num = -1;
                System.out.println("Delete failed.");
            }
        }
        if (attachments.getTableName() != null && attachments.getTableId() != null && attachments.getMark() != null) {
            num = attachmentsMapper.deleteByWhere(attachments);
        }
        return num;
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
        System.out.println(beginStr);
        System.out.println(endStr);
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
        System.out.println(beginStr);
        System.out.println(endStr);
        dataParam.put("beginStr", beginStr);
        dataParam.put("endStr", endStr);
        return dataParam;
    }

    /**
     * 根据行业类别，企业编号，当前时间
     * 获取当天注册的数量
     *
     * @param qyjbxx
     * @return
     */
    public String getDeailyMaxQybm(Qyjbxx qyjbxx) {
        String number = "";//最终组成的序列号
        qyjbxx.setZt("0");
        String qybm = qyjbxxMapper.getDeailyMaxQybm(qyjbxx);
        if (null == qybm || "".equals(qybm)) {
            return number = "000";
        }
        String StringCount1 = qybm.substring(14, 17);
        number = String.valueOf(Integer.parseInt(StringCount1) + 1);
        if (number.length() == 1) {
            number = "00" + number;
        }
        if (number.length() == 2) {
            number = "0" + number;
        }
        //    String  StringCount2 = qybm.substring(0,3);
        //    number =StringCount2+StringCount1;
        return number;
    }

    @Override
    public Map<String, Object> insertQyjbxxBySeal(Qyjbxx record, User user) {
        Map<String, Object> map = new HashMap<>();
        Qyjbxx qyjbxxy = qyjbxxMapper.selectByQymc(record.getQymc());
        if (qyjbxxy == null) {
            record.setHylbdm(hyType);
            record.setLrsj(new Date());
            record.setZt("0");
            int i = qyjbxxMapper.insertSelective(record);
            if (i > 0) {
                map.put("result", 0);
                //成功
                return map;
            } else {
                map.put("result", 2);
                //添加企业信息失败
                return map;
            }
        } else {
            map.put("result", 3);
            //企业信息已存在
            return map;
        }
    }
}
