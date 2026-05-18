package com.kevin.demo.mapper;

import com.kevin.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM student")
    List<User> findAll();

    @Insert("INSERT INTO student(id, name, age) VALUES(#{id}, #{name}, #{age})")
    int addUser(User user);

    @Update("UPDATE student SET name = #{name}, age = #{age} WHERE id = #{id}")
    int updateUser(User user);

    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(int id);

    @Select("SELECT * FROM student WHERE id = #{id}")
    User selectById(int id);

    @Select("SELECT * FROM student LIMIT #{offset}, #{size}")
    List<User> findByPage(@Param("offset") int offset, @Param("size") int size);

    @Delete("DELETE FROM student " +
            "WHERE id NOT IN(" +
            "SELECT *FROM(" +
            "SELECT MIN(id) FROM student GROUP BY name" +
            ") AS temp)")
    int deleteDuplicatesByName();
}