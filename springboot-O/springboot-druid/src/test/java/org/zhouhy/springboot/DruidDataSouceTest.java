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
public class DruidDataSouceTest {
    
    @Resource(name="druidDataSource")
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getClass().toString());
        Connection connection = dataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }
    
}
