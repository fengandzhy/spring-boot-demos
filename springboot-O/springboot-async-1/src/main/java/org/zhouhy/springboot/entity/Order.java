package org.zhouhy.springboot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String orderNumber;
}
