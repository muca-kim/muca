package com.project.repository;

import java.util.List;

import com.project.entity.UserEntity;
import com.project.mapping.UserMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "select u.user_id, u.user_name, u.email from user u where u.role <> 0", nativeQuery = true)
    public List<UserMapping> findAllUser();

    public List<UserEntity> findByUserName(String userName);

}