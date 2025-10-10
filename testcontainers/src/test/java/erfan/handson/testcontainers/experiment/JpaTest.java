package erfan.handson.testcontainers.experiment;

import com.zaxxer.hikari.HikariDataSource;
import erfan.handson.testcontainers.jpa.TestEntity;
import erfan.handson.testcontainers.jpa.TestEntityRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    HikariDataSource dataSource;
    @Autowired
    TestEntityRepository testEntityRepository;

    @Test
    void assertPostgresIsBeingUsed() {
        assertThat(dataSource.getDriverClassName()).isEqualTo("org.postgresql.Driver");
    }

    @Test
    @Sql(scripts = "classpath:sql/data_jpa_test_dml.sql")
    void testGreaterThanTenQuery() {
        List<TestEntity> entities = testEntityRepository.findAllWhereDummyFieldGreaterThanTen();
        assertThat(entities)
                .isNotEmpty()
                .allMatch(entity -> entity.getDummyField() > 10);
    }

    @Test
    @Transactional
    void testLessThanTwentyConstraint() {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(11);
        testEntity.setDummyField(21);
        testEntityRepository.save(testEntity);
        assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy(() -> testEntityManager.flush());
    }
}
