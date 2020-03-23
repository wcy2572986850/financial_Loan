package com.bobcfc.financial_Loan.dao;

import com.bobcfc.financial_Loan.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangchunyu
 * @create 2020-03-17 9:18
 */
@Mapper
public interface UserMapper {


    User selectByName(String username);

    User selectByEmail(String email);

    User selectById(int id);

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);

}
