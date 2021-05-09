package org.zhouhy.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderNo;
    private String userName;
    private int inventory;
    @Column(nullable = false)
    private Integer goodId;
}
