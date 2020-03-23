package com.bobcfc.financial_Loan;


import com.bobcfc.financial_Loan.dao.ProductMapper;
import com.bobcfc.financial_Loan.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;


/**
 * @author wangchunyu
 * @create 2020-03-17 10:12
 */

@SpringBootTest
@ContextConfiguration(classes=FinancialLoanApplication.class)
public class ProductMapperTest {
    @Autowired(required = false)
    private ProductMapper productMapper;

/*    @Test
    public void testInsertProduct() {
        Product product = new Product();
        product.setUserId(1);
        product.setCommentCount(6);
        product.setContent("很不错");
        product.setTitle("添加理财产品成功");
        product.setStatus(2);
        product.setScore(99);
        product.setType(0);

        product.setCreateTime(new Date());

        int rows = productMapper.insertProduct(product);
        System.out.println(rows);
        System.out.println(product.getId());
    }*/
    @Test
    public void testSelectProduct(){
        List<Product> list=productMapper.selectProducts(4,0,10);
        for(Product pro:list){
            System.out.println(pro);
        }

       int count=productMapper.selectProductCount(4);
        System.out.print(count);
    }
}

