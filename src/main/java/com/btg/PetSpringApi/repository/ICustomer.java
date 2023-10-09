package com.btg.PetSpringApi.repository;


import com.btg.PetSpringApi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface ICustomer extends JpaRepository<Customer, Integer>, QuerydslPredicateExecutor<Customer> {

    @Query (value =  "SELECT * FROM CUSTOMER WHERE ACTIVE = TRUE",nativeQuery = true)
    Page<Customer> findAllActiveCustomers(Pageable pageable);

    UserDetails findByEmail(String email);

    List<Customer> findAllByName (String name);

}
