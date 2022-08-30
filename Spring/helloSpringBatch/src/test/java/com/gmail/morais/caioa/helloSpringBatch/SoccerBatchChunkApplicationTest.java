package com.gmail.morais.caioa.helloSpringBatch;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SoccerBatchChunkApplicationTest {

    @Autowired
    private Job job;

    @Autowired
    private DataSource dataSource;

    @Test
    void jobCsvToDataBase() throws SQLException {
        ResultSet resultSet = dataSource
                .getConnection()
                .prepareStatement("select count(*) from TB_USER")
                .executeQuery();

        await().atMost(10, TimeUnit.SECONDS).until(()-> {});
        assertEquals(3, resultSet.getInt(1));
    }
}
