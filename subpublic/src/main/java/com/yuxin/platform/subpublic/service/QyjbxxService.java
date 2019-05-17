package com.yuxin.platform.subpublic.service;

import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.subpublic.pojo.Qyjbxx;
import com.yuxin.platform.subpublic.pojo.QyjbxxExample;
import com.yuxin.platform.upms.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 企业基本信息service
 */
public interface QyjbxxService {

    /**
     * 新增企业信息
     *
     * @param record
     * @return
     */
    Map<String, Object> insertSelective(Qyjbxx record, User user);

    /**
     * 通过企业信息id查询
     *
     * @param qyid
     * @return
     */
    Qyjbxx selectByPrimaryKey(Integer qyid);

    /**
     * @param qymc
     * @return
     */
    List<Qyjbxx> selectByQyzt(String qymc);

    /**
     * 查询所有企业信息
     *
     * @return
     */
    List<Qyjbxx> selectByQyxxzt(User user);

    /**
     * 综治调用点当的企业管理
     *
     * @param id
     * @return
     */
    List<Qyjbxx> selectByQyxxztZhong(String id);

    /**
     * 综治下企业管理查询所有企业信息
     *
     * @return
     */
    List<Qyjbxx> selectByQyxxzt4zz();

    /**
     * 根据企业编码查询企业信息
     *
     * @return
     */
    Qyjbxx selectByQybm(String qybm);

    /**
     * 通过条件查询企业信息
     *
     * @param qyjbxx
     * @return 所有符合条件的企业信息
     */
    List<Qyjbxx> selectByCondition(Qyjbxx qyjbxx, User user);

    /**
     * 综治下企业管理通过条件查询企业信息
     *
     * @param qyjbxx
     * @return 所有符合条件的企业信息
     */
    List<Qyjbxx> selectByCondition4zz(Qyjbxx qyjbxx);

    /**
     * 更新企业信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Qyjbxx record);

    /**
     * 更新企业信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Qyjbxx record);


    List<Qyjbxx> selectByExample(QyjbxxExample example);

    /**
     * 删除图片
     *
     * @param attachments
     * @return int
     */
    int deleteFileMsg(Attachments attachments);


    /**
     * 同步新增印章系统企业信息
     *
     * @param record
     * @return
     */
    Map<String, Object> insertQyjbxxBySeal(Qyjbxx record, User user);
}
