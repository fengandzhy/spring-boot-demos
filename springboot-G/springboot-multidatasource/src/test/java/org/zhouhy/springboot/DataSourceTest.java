package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Resource(name="accountDataSource")
    DataSource accountDataSource;

    @Resource(name="redpackDataSource")
    DataSource redPacketDataSource;

    @Test
    public void contextLoad1() throws SQLException {
        System.out.println(accountDataSource.getClass().toString());
        Connection connection = accountDataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }

    @Test
    public void contextLoad2() throws SQLException {
        System.out.println(redPacketDataSource.getClass().toString());
        Connection connection = redPacketDataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }
}
