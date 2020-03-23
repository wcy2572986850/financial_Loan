package com.bobcfc.financial_Loan.controller;

import com.bobcfc.financial_Loan.entity.Page;
import com.bobcfc.financial_Loan.entity.Product;
import com.bobcfc.financial_Loan.entity.User;
import com.bobcfc.financial_Loan.service.ProductService;
import com.bobcfc.financial_Loan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangchunyu
 * @create 2020-03-20 16:42
 */
@Controller
public class HomeController {
    @Autowired(required = false)
    private ProductService productService;

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        page.setRows(productService.findProductCount(0));
        page.setPath("/index");


        List<Product> list = productService.findProduct(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> products = new ArrayList<>();
        if (list != null) {
            for (Product pro : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("pro", pro);
                User user = userService.findUserById(pro.getUserId());
                map.put("user", user);
                products.add(map);
            }

        }
        model.addAttribute("products",products);


        return "/index";

    }
}
