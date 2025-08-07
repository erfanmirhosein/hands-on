package erfan.handson.testing.testcontainers.springboot;

import com.zaxxer.hikari.HikariDataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.kafka.KafkaContainer;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestContainersTestConfiguration.class)
class TestContainersManagedBySpringBoot {
    @Autowired
    HikariDataSource dataSource;
    @Autowired
    PostgreSQLContainer<?> postgreSQLContainer;
    @Autowired
    KafkaContainer kafkaContainer;
    @Value("${spring.kafka.bootstrap-servers}")
    String kafkaBootstrapServers;

    @Test
    void assertPostgresContainerIsUsed() {
        assertThat(dataSource.getJdbcUrl()).isEqualTo(postgreSQLContainer.getJdbcUrl());
    }

    @Test
    void assertKafkaContainerWasCreated() {
        assertThat(kafkaContainer).isNotNull();
    }

    @Test
    void assertKafkaPropertiesWereSet() {
        assertThat(kafkaBootstrapServers).isEqualTo(kafkaContainer.getBootstrapServers());
    }
}
