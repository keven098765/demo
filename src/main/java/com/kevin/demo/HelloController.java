package com.kevin.demo;

import com.kevin.demo.entity.Result;
import com.kevin.demo.entity.User;
import com.kevin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Result<List<User>> getUsers() {
        List<User> list = userService.findAll();
        return new Result<>(200, "succes", list);
    }

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable int id) {
        User user = userService.selectById(id);
        if (user == null) {
            return new Result<>(404, "id = " + id + "can not find.", null);
        }
        return new Result<>(200, "succes", user);
    }

    @GetMapping("/students")
    public Result<List<User>> findByPage(@RequestParam int page, @RequestParam int size) {
        int offset = (page - 1) * size;
        List<User> list = userService.findByPage(offset, size);
        return new Result<>(200, "succes", list);
    }

    @PostMapping("/add-student")
    public Result<String> addUser(@RequestBody User user) {
        int rows = userService.addUser(user);
        if(rows > 0) {
            return new Result<>(200, "add succesfully: id = " + user.getId(), null);
        } else {
            return new Result<>(500, "add failed", null);
        }
    }

    @DeleteMapping("/delete-student/{id}")
    public Result<String> deleteStudent(@PathVariable int id) {
        int rows = userService.deleteById(id);
        if (rows > 0) {
            return new Result<>(200, "delete successfully", null);
        } else {
            return new Result<>(500, "delete failed", null);
        }
    }

    @PutMapping("/update-student")
    public Result<String> updateStudent(@RequestBody User user) {
        int rows = userService.updateUser(user);
        if (rows > 0) {
            return new Result<>(200, "update successfully", null);
        } else {
            return new Result<>(500, "update failed", null);
        }
    }

}
