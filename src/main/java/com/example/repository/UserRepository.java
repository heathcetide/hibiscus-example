package com.example.repository;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
    
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO users(username, password, email, phone) VALUES(#{username}, #{password}, #{email}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(Long id);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id);
    
    @Update("UPDATE users SET username=#{username}, password=#{password}, email=#{email}, phone=#{phone} WHERE id=#{id}")
    int update(User user);
} 