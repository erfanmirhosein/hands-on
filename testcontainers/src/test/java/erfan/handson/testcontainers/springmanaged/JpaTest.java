package erfan.handson.testcontainers.springmanaged;

import com.zaxxer.hikari.HikariDataSource;
import erfan.handson.testcontainers.jpa.TestEntity;
import erfan.handson.testcontainers.jpa.TestEntityRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
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
        Assertions.assertThatExceptionOfType(
                ConstraintViolationException.class).isThrownBy(() -> testEntityManager.flush());
    }
}
