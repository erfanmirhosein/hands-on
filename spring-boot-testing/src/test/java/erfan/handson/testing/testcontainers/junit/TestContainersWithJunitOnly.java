package erfan.handson.testing.testcontainers.junit;


import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
class TestContainersWithJunitOnly implements Containers {
    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:17-bookworm"));

    @Test
    void assetContainersWereCreated() {
        assertThat(kafkaContainer).isNotNull();
        assertThat(postgreSQLContainer).isNotNull();
    }

    @Test
    void sanityCheckOnPostgres() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(postgreSQLContainer.getJdbcUrl());
        dataSource.setUser(postgreSQLContainer.getUsername());
        dataSource.setPassword(postgreSQLContainer.getPassword());
        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(postgreSQLContainer.getTestQueryString());
            resultSet.next();
            assertThat(resultSet.getInt(1)).isEqualTo(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
