package com.kevin.demo;

import com.kevin.demo.entity.User;
import com.kevin.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userMapper.findAll();
    }
}