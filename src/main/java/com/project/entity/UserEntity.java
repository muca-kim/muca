package com.project.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 유저아이디 */
    @Id
    @Getter
    private String id;
    /** 비밀번호 */
    @Getter
    private String password;
    /** 유저이름 */
    @Getter
    private String name;
    /** 이메일 */
    @Getter
    private String email;
    /** 권한 */
    @Getter
    @Setter
    private Integer role;

    protected UserEntity() {
    }

    @Builder
    protected UserEntity(String id, String password, String name, String email, Integer role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

}