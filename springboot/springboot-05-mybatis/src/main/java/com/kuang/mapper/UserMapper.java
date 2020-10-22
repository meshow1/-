package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示是mybatis的mapper接口， 也可以在springboot05mybatisapplication中加入@mapperscan进行搜索
@Mapper
//在mapper层的component用这个注解,翻译为资料库
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int deleteUser(int id);
}
