package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.dto.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductController {
    
    @RequestMapping(value="/list",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public List<Product> listProduct(){
        List<Product> list = new ArrayList<>();
        Product p1 = new Product(1,"A");
        Product p2 = new Product(2,"B");
        Product p3 = new Product(3,"C");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }
}
