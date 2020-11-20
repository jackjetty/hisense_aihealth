package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.pojo.Member;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 17:25
 *
 * 会员服务接口
 */
public interface MemberServiceApi {

    /**
     * 根据手机号查询会员
     * @param telephone
     * @return
     */
    public Member findByTelephone(String telephone);

    /**
     * 添加会员
     * @param member
     */
    public void add(Member member);

    /**
     * 通过月份查询会员数目
     * @param months
     * @return
     */
    public List<Integer> findMemberCountByMonths(List<String> months);
}
