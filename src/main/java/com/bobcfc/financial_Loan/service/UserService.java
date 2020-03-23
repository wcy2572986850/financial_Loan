package com.bobcfc.financial_Loan.service;

import com.bobcfc.financial_Loan.entity.User;
import com.bobcfc.financial_Loan.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangchunyu
 * @create 2020-03-20 16:26
 */
@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
