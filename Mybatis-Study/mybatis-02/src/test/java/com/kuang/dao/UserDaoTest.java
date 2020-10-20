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
            List<User> userList = mapper.getUserList();

            //方式2(过时)
            //List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");
            for (User user : userList) {
                System.out.println(user);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }



    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);


        //增删改要commit
        //sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid", 5);
        map.put("name", "手打");
        map.put("password", 5222);
        mapper.addUser2(map);
        //sqlSession.commit();


        sqlSession.close();
    }
}
