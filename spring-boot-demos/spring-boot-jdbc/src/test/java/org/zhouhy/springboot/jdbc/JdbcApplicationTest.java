package org.zhouhy.springboot.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JdbcApplicationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoad() throws SQLException {
        log.info(dataSource.getClass().toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();
    }
}
