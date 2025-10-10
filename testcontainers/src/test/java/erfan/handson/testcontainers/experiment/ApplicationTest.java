package erfan.handson.testcontainers.experiment;

import erfan.handson.testcontainers.jpa.TestEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
@DirtiesContext
class ApplicationTest {
    @Autowired
    TestEntityRepository testEntityRepository;

    @Test
    @Sql(scripts = "classpath:sql/data_jpa_test_dml.sql")
    void testEntireApplication() {
        assertThat(testEntityRepository.findAll()).hasSize(5);
    }
}
