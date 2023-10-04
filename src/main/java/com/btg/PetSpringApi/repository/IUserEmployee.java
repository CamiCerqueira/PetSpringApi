package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.UserEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserEmployee extends JpaRepository<UserEmployee, Integer> {

    @Query(value = "SELECT * FROM USEREMPLOYEE WHERE ACTIVE = TRUE", nativeQuery = true)
    Page<UserEmployee> findAllActiveUserEmployees(Pageable pageable);

    Optional<UserEmployee> findByEmail(String email);

    List<UserEmployee> findAllByName(String name);
}
