package com.bobcfc.financial_Loan.service;

/**
 * @author wangchunyu
 * @create 2020-03-20 16:17
 */

import com.bobcfc.financial_Loan.dao.ProductMapper;
import com.bobcfc.financial_Loan.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired(required = false)
    private ProductMapper productMapper;

    public List<Product> findProduct(int userId,int offset,int limit){
        return productMapper.selectProducts(userId, offset, limit);
    }
    public int findProductCount(int userId){
        return productMapper.selectProductCount(userId);
    }
}
