package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPet extends JpaRepository<Pet, Integer> {
    @Override
    @Query(value =  "SELECT * FROM PETS WHERE ACTIVE = TRUE", nativeQuery = true)
    Page<Pet> findAll(Pageable pageable);

    //Tem que fazer outro query? Queremos pesquisar o Pet pelo Customer por ser uma
    // info única sobre o pet para busca no banco.
    // Optional<Customer> findAllByName (String name);

    //Pode haver 2 Optionals? Dletei essa e o encerrou o erro, acredito que
    // pq as duas findAllByName e esse talvez não possa se repetir!
    // Optional<Pet> findAllByName (Integer name);


    Optional<Pet> findAllByBreed (Integer breed);
    List<Pet> findAllByName (Integer name);

}
