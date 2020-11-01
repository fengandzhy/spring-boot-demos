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

    @Resource(name="masterDataSource")
    private DataSource masterDataSource;

    @Resource(name="slaveDataSource")
    private DataSource slaveDataSource;

    @Test
    public void contextLoad1() throws SQLException {
        System.out.println(masterDataSource.getClass().toString());
        Connection connection = masterDataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }

    @Test
    public void contextLoad2() throws SQLException {
        System.out.println(slaveDataSource.getClass().toString());
        Connection connection = slaveDataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }
}
