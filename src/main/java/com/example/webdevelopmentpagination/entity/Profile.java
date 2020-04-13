package com.example.webdevelopmentpagination.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_PROFILE")
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String password;

    public Profile(String name, String description, String password) {
        this.name = name;
        this.description = description;
        this.password = password;
    }
}
