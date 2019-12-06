package com.project.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    private String id;
    @Getter
    private String password;
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private Integer role;

    protected UserEntity() {
    }

    protected UserEntity(String id, String password, String name, String email, Integer role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

}