package com.kevin.demo;

import com.kevin.demo.entity.User;
import com.kevin.demo.entity.Result;
import com.kevin.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/copy")
    public List<User> copyUsers() {
        return userMapper.findAll();
    }

    @GetMapping("/users")
    public Result getUser(){
        List<User> list = userMapper.findAll();
        return new Result(200, "succes", list);
    }

    @GetMapping("/test-add")
    public String testAdd() {
        User user = new User();
        user.setId(100);
        user.setName("text");
        user.setAge(30);
        int rows = userMapper.addUser(user);
        return "change " + rows + " lines";
    }

    @GetMapping("/test-update")
    public String testUpdate(){
        User user = new User();
        user.setId(100);
        user.setName("new name");
        user.setAge(35);
        int rows = userMapper.updateUser(user);
        return "change" + rows + "lines";
    }

    @GetMapping("/test-delete")
    public String testDelete(){
        int rows = userMapper.deleteById(100);
        return "deleted " + rows + " lines";
    }

    @GetMapping("/user/{id}")
    public Object getUser(@PathVariable int id){
        User user = userMapper.selectById(id);
        if(user == null) {
           return "id = " + id + " can not find.";
        }
        return user;
    }

    @GetMapping("/add-student")
    public String addStudent(@RequestParam int id, @RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        int rows = userMapper.addUser(user);
        if(rows > 0){
            return "add succesfully: id = " + id;
        } else {
            return "Fail";
        }
    }

    @GetMapping("/students")
    public Result getStudent(@RequestParam int page, @RequestParam int size){
        int offset = (page - 1) * size;
        List<User> list = userMapper.findByPage(offset, size);
        return new Result(200, "succes", list);
    }

    @GetMapping("/clean-duplicates")
    public Result cleanDuplicates(){
        int rows = userMapper.deleteDuplicatesByName();
        return new Result(200, "deleted " + rows + " messages", null);
    }
}
