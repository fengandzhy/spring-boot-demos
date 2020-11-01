package org.zhouhy.springboot.druid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidApplicationTest {

    @Resource(name="masterDataSource")
    private DataSource masterdataSource;

    @Resource(name="slaverDataSource")
    private DataSource slaverdataSource;

    @Test
    public void contextLoad() throws SQLException {
        System.out.println(masterdataSource.getClass().toString());
        Connection connection = masterdataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }

    @Test
    public void contextLoad2() throws SQLException {
        System.out.println(slaverdataSource.getClass().toString());
        Connection connection = slaverdataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }
}
