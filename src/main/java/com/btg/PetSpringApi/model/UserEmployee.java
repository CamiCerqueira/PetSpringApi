package com.btg.PetSpringApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name="userEmployee")
@Where(clause = "active is true")
public class UserEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private Boolean active;

}
