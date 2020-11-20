package com.hisense.keylab.aihealth.dao;

import com.github.pagehelper.Page;
import com.hisense.keylab.aihealth.pojo.Member;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 14:21
 *
 * 会员dao
 */
public interface MemberDao {
    /**
     * 查询所有会员
     * @return
     */
    public List<Member> findAll();

    /**
     * 根据条件查询会员
     * @param queryString
     * @return
     */
    public Page<Member> selectByCondition(String queryString);

    /**
     * 新增会员
     * @param member
     */
    public void add(Member member);

    /**
     * 根据id删除会员
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 根据 id 查询会员
     * @param id
     * @return
     */
    public Member findById(Integer id);

    /**
     * 根据电话号码查询会员
     * @param telephone
     * @return
     */
    public Member findByTelephone(String telephone);

    /**
     * 编辑会员
     * @param member
     */
    public void edit(Member member);

    /**
     * 查询某日期前会员数
     * @param date
     * @return
     */
    public Integer findMemberCountBeforeDate(String date);

    /**
     * 查询某天会员数目
     * @param date
     * @return
     */
    public Integer findMemberCountByDate(String date);

    /**
     * 查询某日后会员数目
     * @param date
     * @return
     */
    public Integer findMemberCountAfterDate(String date);

    /**
     * 根据总人数查询会员数
     * @return
     */
    public Integer findMemberTotalCount();
}
