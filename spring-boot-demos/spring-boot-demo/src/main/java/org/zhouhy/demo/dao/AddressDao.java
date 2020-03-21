package org.zhouhy.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhouhy.demo.entity.Address;

public interface AddressDao extends JpaRepository<Address,Integer> {


}
