package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrder extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM ORDERS WHERE USER_ID = :userId", nativeQuery = true)
    List<Order> findAllByUser(Integer userId);

    @Query(value = "SELECT order FROM Order order JOIN order.products product WHERE product.id = :productId")
    List<Order> findAllByProduct(Integer productId);
}
