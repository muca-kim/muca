package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.project.entity.UserEntity;
import com.project.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {

        List<UserEntity> user = userRepository.findAll();
        user.stream().forEach(System.out::println);
        System.out.println("user:" + user.size());
        assertEquals(new ArrayList<UserEntity>(), user);
    }
}