package org.zhouhy.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.zhouhy.springboot.entity.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
