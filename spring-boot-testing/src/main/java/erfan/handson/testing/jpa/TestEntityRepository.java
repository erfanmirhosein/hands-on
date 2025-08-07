package erfan.handson.testing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestEntityRepository extends JpaRepository<TestEntity, Integer> {
    @Query("select te from TestEntity te where te.dummyField > 10")
    List<TestEntity> findAllByDummyFieldGreaterThanTen();
}
