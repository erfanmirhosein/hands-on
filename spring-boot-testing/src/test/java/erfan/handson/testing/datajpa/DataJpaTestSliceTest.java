package erfan.handson.testing.datajpa;

import erfan.handson.testing.jpa.TestEntity;
import erfan.handson.testing.jpa.TestEntityRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DataJpaTestSliceConfiguration.class)
class DataJpaTestSliceTest {
    @Autowired
    TestEntityRepository testEntityRepository;
//    @Autowired
//    EntityManager testEntityManager;

    @Test
    @Sql(scripts = "classpath:sql/data_jpa_test_dml.sql")
    void testGreaterThanTenQuery() {
        List<TestEntity> entities = testEntityRepository.findAllByDummyFieldGreaterThanTen();
        Assertions.assertThat(entities).allMatch(entity -> entity.getDummyField() > 10);
    }
}
