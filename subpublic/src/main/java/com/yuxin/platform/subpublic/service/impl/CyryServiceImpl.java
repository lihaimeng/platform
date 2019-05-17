/**
 * @author wj
 * <p>
 * 2018年1月31日
 */
package com.yuxin.platform.subpublic.service.impl;

import com.yuxin.platform.common.mapper.AttachmentsMapper;
import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.util.GenerateCode;
import com.yuxin.platform.subpublic.mapper.QyjbxxMapper;
import com.yuxin.platform.subpublic.mapper.QyryxxMapper;
import com.yuxin.platform.subpublic.pojo.Qyjbxx;
import com.yuxin.platform.subpublic.pojo.Qyryxx;
import com.yuxin.platform.subpublic.service.CyryService;
import com.yuxin.platform.subpublic.vo.QyryVo;
import com.yuxin.platform.upms.mapper.OrganizationMapper;
import com.yuxin.platform.upms.mapper.RoleMapper;
import com.yuxin.platform.upms.mapper.UserMapper;
import com.yuxin.platform.upms.mapper.UserRoleMapper;
import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.Role;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.pojo.UserRole;
import com.yuxin.platform.upms.util.CipherUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CyryServiceImpl implements CyryService {

    @Autowired
    private QyryxxMapper qyryxxMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private AttachmentsMapper attachmentsMapper;

    @Autowired
    private QyjbxxMapper qyjbxxMapper;

    @Autowired
    private RoleMapper rolemapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Value("${password}")
    private String password;

    @Value("${hyType}")
    private String hyType;

    @Value("${rybj}")
    private String rybj;
    /*@Override
    public int deleteByPrimaryKey(Integer ryid) {
        return qyryxxMapper.deleteByPrimaryKey(ryid);
    }*/

    @Transactional
    @Override
    public int deleteByPrimaryKey(Integer ryid) {
        Qyryxx qyryxx = new Qyryxx();
        User user = new User();
        qyryxx.setRyid(ryid);
        qyryxx.setScbz((short) 1);
        Qyryxx qyryxx1 = qyryxxMapper.selectByPrimaryKey(ryid);
        User user1 = userMapper.selectByUserName(qyryxx1.getCyrybh());
        user.setStatus((byte) 0);
        user.setUserId(user1.getUserId());
        userMapper.updateByPrimaryKeySelective(user);
        return qyryxxMapper.updateByPrimaryKeySelective(qyryxx);
    }

    @Transactional
    @Override
    public int insert(Qyryxx record, Role role, User user1) {
        int i = 1;
        Qyjbxx qyglyQyjbxx = qyjbxxMapper.selectByQybm(user1.getQyrybm());
        Organization organization = organizationMapper.selectByPrimaryKey(user1.getOrganizationId());
        String code = organization.getCode();
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        UserRole UserRole = new UserRole();
        //企业管理员
        if (qyglyQyjbxx != null) {
            String qyrybm = "";
            String qybm = qyglyQyjbxx.getQybm();
            record.setQyid(qyglyQyjbxx.getQyid());
            record.setScbz((short) 0);
            map.put("qyid", qyglyQyjbxx.getQyid());
            record.setLrsj(new Date());
            record.setHylbdm(hyType);
            record.setXzdxzqhdm(qyglyQyjbxx.getGxdwbm());

            String cyrybh = record.getCyrybh();
            if(StringUtils.isEmpty(cyrybh)){
                cyrybh = GenerateCode.strFormat(//生成cyrybm
                        rybj, hyType, record.getXzdxzqhdm(), getDeailyMaxCyrybm(record));
            }
            record.setCyrybh(cyrybh);
            // record.setHylbdm(qyglyQyjbxx.getHylbdm());
            // record.setHylb(qyglyQyjbxx.getHylb());
            user.setQyrybm(qybm);
        }
        //用户名= 从业人员编码
        user.setUsername(record.getCyrybh());
        user.setRealname(record.getXm());
        user.setStatus((byte) 1);
        user.setSex("03001".equals(record.getXb()) ? (byte) 1 : (byte) 2);
        user.setPhone(record.getLxdh());
        user.setPassword(CipherUtil.generatePassword(password));
        user.setAddtime(new Date());
        user.setOrganizationId(user1.getOrganizationId());
        userMapper.insertSelective(user);
        if ("02301".equals(role.getName())) {
            UserRole.setRoleId(196);
        }
        UserRole.setUserId(user.getUserId());
        userRoleMapper.insertSelective(UserRole);
        String mzdm = record.getMzdm();
        String cyzjdm = record.getCyzjdm();
        String whcddm = record.getWhcddm();
        String cyryztdm = "01701";
        String xbdm = record.getXbdm();
        record.setCyryztdm(cyryztdm);
        record.setCyryzt("在岗");
        return qyryxxMapper.insert(record);
    }

    @Override
    public int insertSelective(Qyryxx record) {
        return qyryxxMapper.insertSelective(record);
    }

    @Override
    public Qyryxx selectByPrimaryKey(Integer ryid) {
        return qyryxxMapper.selectByPrimaryKey(ryid);
    }

    /*
    页面加载列表
     */
    @Transactional
    @Override
    public List<QyryVo> selectQyryxxs(Map<String, Object> map, User user) {
        if (user.getQyrybm() != null && !"".equals(user.getQyrybm())) {//qyrybm不为null 可能是企业管理员，或者是普通员工
            Qyjbxx qyglyQyjbxx = qyjbxxMapper.selectByQybm(user.getQyrybm());
            if (qyglyQyjbxx != null) {//企业管理员:企业表、用户表存在数据
                map.put("qyid", qyglyQyjbxx.getQyid());
            } else {//普通员工:用户表、人员表存在数据
                Qyryxx qyryxx = qyryxxMapper.selectByRybh(user.getQyrybm());
                if (qyryxx != null) {
                    map.put("qyid", qyryxx.getQyid());
                }
            }
        }
        List<QyryVo> ryList = qyryxxMapper.selectQyryxxs(map);
        for (QyryVo qyryxx : ryList) {
            //从业人员编码 = username
            String rybm = qyryxx.getCyrybh();
            if (rybm != null) {
                User user1 = userMapper.findByUserName(rybm);
                if (user1 != null) {
                    UserRole ur = userRoleMapper.selectByUserId(user1.getUserId());
                    Role role = rolemapper.selectByPrimaryKey(ur.getRoleId());
                    String roleName = role.getName();
                    qyryxx.setRoleName(roleName);
                }
            }
        }
        return ryList;
    }

    /*
    综治日常管理跨域请求
     */
    @Override
    public List<QyryVo> selectQyryxxsForDaily(Map<String, Object> map) {
        //区域管理员
        List<QyryVo> qyrys = qyryxxMapper.selectQyryxxsForDaily(map);
        for (QyryVo qyryvo : qyrys) {
            String rybm = qyryvo.getCyrybh();
            if (rybm != null) {
                User user1 = userMapper.findByUserName(rybm);
                if (user1 != null) {
                    UserRole ur = userRoleMapper.selectByUserId(user1.getUserId());
                    String roleName = rolemapper.selectByPrimaryKey(ur.getRoleId()).getName();
                    qyryvo.setRoleName(roleName);
                }
            }
        }

        return qyrys;
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Qyryxx record, Role role) {
        UserRole userRole = new UserRole();
        User user = new User();
        record.setScbz((short) 2);
        if ("02301".equals(role.getName())) {
            userRole.setRoleId(196);
        }
        /*if ("1".equals(role.getName())) {
            userRole.setRoleId(197);
        }*/
        String cyrybh = qyryxxMapper.selectByPrimaryKey(record.getRyid()).getCyrybh();
        Integer userid = userMapper.findByUserName(cyrybh).getUserId();
        UserRole us = userRoleMapper.selectByUserId(userid);
        if (us != null) {
            userRole.setUserRoleId(us.getUserRoleId());
        }
        String cyryztdm = record.getCyryztdm();
        //离职
        if ("01702".equals(cyryztdm)) {
            user.setStatus((byte) 0);
            user.setUserId(userid);
            userMapper.updateByPrimaryKeySelective(user);
        }
        userRoleMapper.updateByPrimaryKeySelective(userRole);
        return qyryxxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Qyryxx selectByCyrybh(String cyrybh) {
        return qyryxxMapper.selectByRybh(cyrybh);
    }

    @Transactional
    @Override
    public int insertAttach(Attachments attachments, String userName) {
        // TODO Auto-generated method stub
        int row = -1;
        if (attachments != null) {
            attachments.setCreater(userName);
            attachments.setCreateDate(new Date());
            row = attachmentsMapper.insertSelective(attachments);
        }
        return row;
    }

    @Transactional
    @Override
    public int updateAttach(Attachments attachments, String userName) {
        // TODO Auto-generated method stub
        int row = -1;
        if (!"".equals(attachments.getRealPath())) {
            attachments.setCreater(userName);
            attachments.setCreateDate(new Date());
            Attachments attachment = attachmentsMapper.getAttachment(attachments);
            if (attachment != null) {
                File file = new File(attachment.getRealPath());
                if (file != null) {
                    if (file.delete()) {
                        System.out.println(file.getName() + "is deleted");
                    } else {
                        System.out.println("Delete failed.");
                    }
                }
                attachments.setId(attachment.getId());
                row = attachmentsMapper.updateByPrimaryKeySelective(attachments);
            } else {
                row = attachmentsMapper.insertSelective(attachments);
            }
        }
        return row;
    }

    public String strFormat(String str) {
        String newStr = str.substring(str.length() - 4);
        String str1 = str.substring(0, str.length() - 4);
        System.out.println(newStr);
        int i = Integer.parseInt(newStr);
        System.out.println(i);
        DecimalFormat df = new DecimalFormat("0000");
        String str2 = df.format(i + 1);
        System.out.println(str2);
        return str1 + str2;
    }

    public String getDeailyMaxCyrybm(Qyryxx qyryxx) {
        String number = "";
        qyryxx.setCyryztdm("01701");
        String cyrybm = qyryxxMapper.getDeailyMaxCyrybm(qyryxx);
        if (null == cyrybm || "".equals(cyrybm)) {
            return number = "000";
        }
        String StringCount1 = cyrybm.substring(14, 17);
        number = String.valueOf(Integer.parseInt(StringCount1) + 1);

        if (number.length() == 1) {
            number = "00" + number;
        }
        if (number.length() == 2) {
            number = "0" + number;
        }
        //   String  StringCount2 = cyrybm.substring(0,13);
        //   number =StringCount2+StringCount1;
        return number;
    }

    @Override
    public int insertCyryBySeal(Qyryxx qyryxx) {
        qyryxx.setCyryztdm("01701");
        qyryxx.setHylbdm(hyType);
        return qyryxxMapper.insert(qyryxx);
    }
}
