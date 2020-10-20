package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

//    参数前面加上@param注解
    @Select("select * from user where id=#{id} and name=#{name}")
    User getUserById(@Param("id") int id, @Param("name") String name);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);
}
