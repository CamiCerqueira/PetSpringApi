package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrder extends JpaRepository<Order,Double>, QuerydslPredicateExecutor<Order> {

    @Query(value = "SELECT * FROM ORDERS WHERE CUSTOMER_ID = :customerId", nativeQuery = true)
    List<Order> findAllByCustomer(Integer customerId);

    @Query(value = "SELECT order FROM Order order JOIN order.products product WHERE product.id = :productId")
    Optional<Order> findAllByProduct(Double productId);

    @Query("SELECT o FROM Order o WHERE o.totalPrice>= :minPrice AND o.totalPrice <= :maxPrice")
    List<Order> findAllByPrice(double minPrice, double maxPrice);

}



