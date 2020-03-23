package com.bobcfc.financial_Loan;


import com.bobcfc.financial_Loan.dao.UserMapper;
import com.bobcfc.financial_Loan.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;


/**
 * @author wangchunyu
 * @create 2020-03-17 10:12
 */

@SpringBootTest
@ContextConfiguration(classes=FinancialLoanApplication.class)
public class MapperTests {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(1);
        System.out.println(user);

        user = userMapper.selectByName("wuliuqi");
        System.out.println(user);

        user = userMapper.selectByEmail("523016968@qq.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("meihua");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(3, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(3, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(3, "hello");
        System.out.println(rows);
    }
}
