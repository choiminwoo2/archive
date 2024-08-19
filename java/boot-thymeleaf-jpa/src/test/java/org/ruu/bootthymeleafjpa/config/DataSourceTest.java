package org.ruu.bootthymeleafjpa.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import javax.sql.DataSource;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    @Test
    void connection() throws Exception {
        @Cleanup Connection connection = dataSource.getConnection();
        log.info(connection);
        assertThat(connection).isNotNull();
    }
}
