package erfan.handson.testcontainers.singleton;

import erfan.handson.testcontainers.jpa.TestEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = TestContainersInitializer.class)
class SingletonContainerApplicationTest {
    @Autowired
    TestEntityRepository testEntityRepository;

    @Test
    void testEntireApplication() {
        Assertions.assertNotNull(testEntityRepository);
    }
}
