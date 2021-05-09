package org.zhouhy.springboot.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zhouhy.springboot.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory,Long> {

    @Modifying
    @Query(value = "update t_inventory set inventory=:inventory, version=version+1 where id=:id and version=:version",nativeQuery = true)
    int updateById(@Param("id")Long Id, @Param("inventory")int inventory,@Param("version")int version);
}
