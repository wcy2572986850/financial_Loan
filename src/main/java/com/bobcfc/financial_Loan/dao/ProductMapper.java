package com.bobcfc.financial_Loan.dao;

import com.bobcfc.financial_Loan.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangchunyu
 * @create 2020-03-17 15:44
 */
@Mapper
public interface ProductMapper {
    List<Product> selectProducts(@Param("userId")int userId,@Param("offset")int offset,@Param("limit")int limit);//offset每一页起始行的行号，limit每一页显示多少行

    //@Param注解用于给参数取别名，如果只有一个参数，并且在<if>里使用，则必须加别名
    int selectProductCount(@Param("userId") int userId);//查询一共有多少个产品

    int insertProduct(Product product);
}
