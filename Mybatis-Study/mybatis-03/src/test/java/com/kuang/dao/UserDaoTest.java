package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession =MybatisUtils.getSqlSession();


        try {
            //方式1
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

}

