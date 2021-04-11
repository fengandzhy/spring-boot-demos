package org.zhouhy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhouhy.springboot.entity.Brand;
import org.zhouhy.springboot.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    
    @RequestMapping(value={"","/","/index"})
    public String index(){        
        return "index";
    }

    @RequestMapping(value="demo1")
    public String demo1(){
        return "demo1";
    }

    @RequestMapping(value="demo2")
    public String demo2(){
        return "demo2";
    }

    @RequestMapping(value="demo3")
    public String demo3(){
        return "demo3";
    }

    @RequestMapping(value="demo4")
    public String demo4(Model model){
        List<Brand> list = new ArrayList<>();
        Brand brand1 = new Brand(1,"Tesla",200.00);
        Brand brand2 = new Brand(2,"Benz",200.00);
        Brand brand3 = new Brand(3,"BMW",200.00);
        Brand brand4 = new Brand(4,"Honda",200.00);
        Brand brand5 = new Brand(5,"Toyota",200.00);
        list.add(brand1);
        list.add(brand2);
        list.add(brand3);
        list.add(brand4);
        list.add(brand5);
        model.addAttribute("brands",list);

        Category category = new Category();
        category.setContent("3");
        
        model.addAttribute("category",category);
        model.addAttribute("num",1678);

        model.addAttribute("userphone","18360554400");
        model.addAttribute("name","obstra");
        
        return "demo4";
    }
    
    
}
