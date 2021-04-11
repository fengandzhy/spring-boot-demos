package org.zhouhy.springboot.entity;

import lombok.Data;

@Data
public class Brand {
    private int Id;
    private String name;
    private Double price;
    
    public Brand(int Id,String name,Double price){
        this.Id = Id;
        this.name = name;
        this.price = price;
    }
}
