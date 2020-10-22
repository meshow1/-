package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    //在配置文件中配置后直接注入
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看数据源，为class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //其中XXXtemplate表示springboot配置好的模板bean，可以直接使用
        //比如 jdbctemplateconfiguration中的jdbctemplate


        connection.close();
    }

}
