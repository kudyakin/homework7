package com.kudiukin.homework6.repository;

import com.kudiukin.homework6.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
}
