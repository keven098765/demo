package com.kevin.demo.service;

import com.kevin.demo.entity.User;
import com.kevin.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    public int deleteDuplicatesByName() {
        return userMapper.deleteDuplicatesByName();
    }

    public List<User> findByPage(@Param("offset") int offset, @Param("size") int size) {
        return userMapper.findByPage(offset, size);
    }
}
