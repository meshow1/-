package com.kuang.dao;

import com.kuang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

//mybatis并不需要创建实现类，如果用spring则需要创建一个实现类进行实现以使得程序可以调用方法
public class UserMapperImpl implements UserMapper{

   private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
       UserMapper mapper =sqlSession.getMapper(UserMapper.class);
       return mapper.selectUser();
    }
}
