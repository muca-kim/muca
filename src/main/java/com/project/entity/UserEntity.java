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
@Getter
@Setter
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 유저아이디 */
    @Id
    private String userId;
    /** 비밀번호 */
    private String userPassword;
    /** 유저이름 */
    private String userName;
    /** 이메일 */
    private String email;
    /** 권한 */
    private Integer role;

    protected UserEntity() {
    }

    public UserEntity(String userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    @Builder
    public UserEntity(String userId, String userPassword, String userName, String email, Integer role) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

}