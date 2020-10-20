package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

//mybatis并不需要创建实现类，如果用spring则需要创建一个实现类进行实现以使得程序可以调用方法
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{


    @Override
    public List<User> selectUser() {
        User user = new User(5, "小王", "12344");


        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(user);
        mapper.deleteUser(5);


        return mapper.selectUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
