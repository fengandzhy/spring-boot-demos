package org.zhouhy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhouhy.springboot.entity.Inventory;
import org.zhouhy.springboot.entity.Order;
import org.zhouhy.springboot.repository.InventoryRepository;
import org.zhouhy.springboot.repository.OrderRepository;
import org.zhouhy.springboot.util.UUIDUtil;

import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Transactional
    public void createOder(){
        Optional<Inventory> optional = inventoryRepository.findById(1l);
        if(!optional.isPresent()){
            throw new RuntimeException("没有对应的文章");
        }
        Inventory inventory = optional.get();
        Order order = new Order();
        order.setGoodId(1);
        order.setInventory(inventory.getInventory());
        order.setOrderNo(UUIDUtil.getOrderIdByUUId());
        order.setUserName("Sam");
        orderRepository.save(order);
        int count = inventoryRepository.updateById(inventory.getId(),inventory.getInventory()-1,inventory.getVersion());
        if (count == 0) {
            throw new RuntimeException("服务器繁忙,更新数据失败");
        }
    }
}
