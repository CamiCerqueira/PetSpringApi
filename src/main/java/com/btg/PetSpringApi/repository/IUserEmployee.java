package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.UserEmployee;
import com.btg.PetSpringApi.utils.UserEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserEmployee extends JpaRepository<UserEmployee, String> {

    @Override
    @Query(value = "SELECT * FROM USERS WHERE ACTIVE = TRUE", nativeQuery = true)
    Page<UserEmployee> findAll(Pageable pageable);

    Optional<UserEmployee> findByEmail(String email);

    List<UserEmployee> findAllByName(String name);

    Optional<UserEmployee> findById(Integer id);
}
