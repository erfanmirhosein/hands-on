package erfan.handson.testcontainers.springmanaged;

import erfan.handson.testcontainers.jpa.TestEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class ApplicationTest {
    @Autowired
    TestEntityRepository testEntityRepository;

    @Test
    void testEntireApplication() {
        Assertions.assertNotNull(testEntityRepository);
    }
}
